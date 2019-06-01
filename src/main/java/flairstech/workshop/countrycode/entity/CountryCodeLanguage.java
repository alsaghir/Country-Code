package flairstech.workshop.countrycode.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CountryCodeLanguage implements Serializable {

    public CountryCodeLanguage(){}

    @Column(name = "country_code", insertable = false, updatable = false)
    private String countryCode;

    @Column(name = "language")
    private String language;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}