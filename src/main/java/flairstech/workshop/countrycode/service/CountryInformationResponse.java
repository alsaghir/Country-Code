package flairstech.workshop.countrycode.service;

import flairstech.workshop.countrycode.entity.Country;
import flairstech.workshop.countrycode.entity.CountryLanguage;

public class CountryInformationResponse implements GenericResponse {
    private String name;
    private String continent;
    private long population;
    private double lifeExpectancy;
    private String language;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public double getLifeExpectancy() {
        return lifeExpectancy;
    }
    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    // Implementing builder pattern
    private CountryInformationResponse(Builder builder){
        name = builder.name;
        continent = builder.continent;
        population = builder.population;
        lifeExpectancy = builder.lifeExpectancy;
        language = builder.language;
    }
    private static class Builder{
        private String name;
        private String continent;
        private long population;
        private double lifeExpectancy;
        private String language;

         Builder() {}

         Builder name(String name) {
             this.name = name;
            return this;
        }
         Builder continent(String continent) {
             this.continent = continent;
            return this;
        }
         Builder population(long population) {
             this.population = population;
            return this;
        }
         Builder lifeExpectancy(double lifeExpectancy) {
             this.lifeExpectancy = lifeExpectancy;
            return this;
        }
         Builder language(String language) {
             this.language = language;
            return this;
        }

        CountryInformationResponse build() {
            return new CountryInformationResponse(this);
        }
    }

    // Using builder pattern for converting to DTO
    static CountryInformationResponse convert(Country country, CountryLanguage countryLanguage){
        return new Builder()
                .name(country.getName())
                .continent(country.getContinent())
                .population(country.getPopulation())
                .lifeExpectancy(country.getLifeExpectancy())
                .language(countryLanguage.getCountryCodeLanguage().getLanguage()).build();
    }
}
