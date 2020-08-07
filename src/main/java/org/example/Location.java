package org.example;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "LOCATIONS")
public class Location {

    public Location() {
    }

    public Location(String streetAdderss, String postalCode, String city, String stateProvince, int countryId, List<Department> departments) {
        this.streetAdderss = streetAdderss;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryId = countryId;
        this.departments = departments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOCATION_ID")
    private int locationId;

    @Column(name = "STREET_ADDRESS")
    private String streetAdderss;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String stateProvince;

    @Column(name = "COUNTRY_ID")
    private int countryId;

    @OneToMany(mappedBy = "location")//, fetch = FetchType.EAGER)
    private List<Department> departments;


    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getStreetAdderss() {
        return streetAdderss;
    }

    public void setStreetAdderss(String streetAdderss) {
        this.streetAdderss = streetAdderss;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", streetAdderss='" + streetAdderss + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", countryId=" + countryId +
                ", departments=" +
                '}';
    }
}
