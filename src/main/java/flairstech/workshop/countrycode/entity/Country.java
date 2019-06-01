package flairstech.workshop.countrycode.entity;


import javax.persistence.*;

@Entity
public class Country {

    @Id
    private String code;

    @Column
    private String name;

    @Column
    private String continent;

    @Column
    private String region;

    @Column
    private double surfaceArea;

    @Column
    private long indepYear;

    @Column
    private long population;

    @Column
    private double lifeExpectancy;

    @Column
    private String gnp;

    @Column
    private String gnpOld;

    @Column
    private String localName;

    @Column
    private String governmentForm;

    @Column
    private String headOfState;

    @Column
    private String code2;

    @OneToOne
    @JoinColumn(name = "capital")
    private City capital;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
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
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public double getSurfaceArea() {
        return surfaceArea;
    }
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }
    public long getIndepYear() {
        return indepYear;
    }
    public void setIndepYear(long indepYear) {
        this.indepYear = indepYear;
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
    public String getGnp() {
        return gnp;
    }
    public void setGnp(String gnp) {
        this.gnp = gnp;
    }
    public String getGnpOld() {
        return gnpOld;
    }
    public void setGnpOld(String gnpOld) {
        this.gnpOld = gnpOld;
    }
    public String getLocalName() {
        return localName;
    }
    public void setLocalName(String localName) {
        this.localName = localName;
    }
    public String getGovernmentForm() {
        return governmentForm;
    }
    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }
    public String getHeadOfState() {
        return headOfState;
    }
    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }
    public City getCapital() {
        return capital;
    }
    public void setCapital(City capital) {
        this.capital = capital;
    }
    public String getCode2() {
        return code2;
    }
    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
