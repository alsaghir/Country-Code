package flairstech.workshop.countrycode.entity;

import javax.persistence.*;

@Entity
public class CountryLanguage {

    @EmbeddedId
    private CountryCodeLanguage countryCodeLanguage;

    @Column
    private Boolean isOfficial;

    @Column
    private double percentage;

    @OneToOne
    @JoinColumn(name = "country_code", insertable=false, updatable=false)
    private Country country;

    public CountryLanguage(){}

    public CountryCodeLanguage getCountryCodeLanguage() { return countryCodeLanguage; }
    public void setCountryCodeLanguage(CountryCodeLanguage countryCodeLanguage) { this.countryCodeLanguage = countryCodeLanguage; }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public Boolean getOfficial() {
        return isOfficial;
    }
    public void setOfficial(Boolean official) {
        isOfficial = official;
    }
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
