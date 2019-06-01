package flairstech.workshop.countrycode.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import flairstech.workshop.countrycode.entity.Country;
import flairstech.workshop.countrycode.entity.CountryLanguage;
import flairstech.workshop.countrycode.repository.CountryLanguageRepository;
import flairstech.workshop.countrycode.repository.CountryRepository;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CountryInformation {

    private final CountryRepository countryRepository;
    private final CountryLanguageRepository countryLanguageRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public CountryInformation(CountryRepository countryRepository,
                              CountryLanguageRepository countryLanguageRepository,
                              ObjectMapper objectMapper) {
        this.countryRepository = countryRepository;
        this.countryLanguageRepository = countryLanguageRepository;
        this.objectMapper = objectMapper;
        this.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<GenericResponse> countryInformation(@PathVariable String countryCode){

        try {
            Optional<Country> country = countryRepository.findById(countryCode);
            List<CountryLanguage> countryLanguageList = null;

            // If country is not there, no need to continue
            if (country.isPresent())
                countryLanguageList = countryLanguageRepository.findByCountryCodeLanguage_CountryCode(countryCode);
            else
                return new ResponseEntity<>(new ErrorResponse("INVALID_COUNTRY_CODE"), HttpStatus.INTERNAL_SERVER_ERROR);

            // Retrieve the country official language
            Optional<CountryLanguage> countryLanguage = CollectionUtils.isEmpty(countryLanguageList)
                    ? Optional.empty()
                    : countryLanguageList.parallelStream().filter(CountryLanguage::getOfficial).findFirst();

            //prepare the response
            CountryInformationResponse response = countryLanguage.map(language ->
                    CountryInformationResponse.convert(country.get(), language)).orElse(null);

            // Final response
            return response != null
                    ? new ResponseEntity<>(response, HttpStatus.OK)
                    : new ResponseEntity<>(new ErrorResponse("INVALID_COUNTRY_CODE"), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (JDBCConnectionException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResponse("INTERNAL_ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResponse("UNKNOWN_ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
