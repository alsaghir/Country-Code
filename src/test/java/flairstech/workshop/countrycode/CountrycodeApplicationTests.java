package flairstech.workshop.countrycode;

import flairstech.workshop.countrycode.repository.CountryRepository;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.SQLException;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CountrycodeApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CountryRepository countryRepository;

	@Test
	public void nonExistentCode() throws Exception {

		//given + when
		Mockito.when(countryRepository.findById("NonExistingCode")).thenReturn(Optional.empty());

		//then
		mvc.perform(get("/NonExistingCode").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError())
				.andExpect(content().json("{error_message: INVALID_COUNTRY_CODE}"));

	}

	@Test
	public void databaseConnectionProblem() throws Exception {

		//given + when
		Mockito.when(countryRepository.findById("NO_DB_CONNECTION")).thenThrow(
				new JDBCConnectionException("Mock error connecting to database", new SQLException()));

		//then
		mvc.perform(get("/NO_DB_CONNECTION").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError())
				.andExpect(content().json("{error_message: INTERNAL_ERROR}"));
	}

}
