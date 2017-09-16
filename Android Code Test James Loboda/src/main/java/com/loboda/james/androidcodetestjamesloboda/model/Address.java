package com.loboda.james.androidcodetestjamesloboda.model;

import io.realm.RealmObject;

/**
 * Created by Twaltex on 9/12/2017.
 */

public class Address extends RealmObject{

    private String street, street2;
    private String city, state, country;
    private long zipcode;

    public Address() {
        this.street = "";
        this.street2 = "";
        this.city = "";
        this.state = "";
        this.country = "United States";
        this.zipcode = 0;
    }

    public Address(String street, String street2, String city, String state, long zipcode, String country) {

        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;

    }

    public void setValues(String street, String street2, String city, String state, long zipcode, String country) {

        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }
}
