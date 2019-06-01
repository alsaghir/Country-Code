package flairstech.workshop.countrycode.repository;

import flairstech.workshop.countrycode.entity.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {
    public List<CountryLanguage> findByCountryCodeLanguage_CountryCode(String countryCode);
}
