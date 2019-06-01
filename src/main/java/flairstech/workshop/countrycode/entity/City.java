package flairstech.workshop.countrycode.entity;

import javax.persistence.*;

@Entity
public class City {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String district;

    @Column
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country country;

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public Integer getPopulation() {
        return population;
    }
    public void setPopulation(Integer population) {
        this.population = population;
    }
}
