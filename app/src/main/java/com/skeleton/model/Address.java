package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * address
 */
public class Address {
    @SerializedName("street")
    private String street;
    @SerializedName("suite")
    private String suite;
    @SerializedName("city")
    private String city;
    @SerializedName("zipcode")
    private String zipcode;
    @SerializedName("geo")
    private Geo geo;

    /**
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street of location
     */
    public void setStreet(final String street) {
        this.street = street;
    }

    /**
     * @return suite of user location
     */
    public String getSuite() {
        return suite;
    }

    /**
     * @param suite of user location
     */
    public void setSuite(final String suite) {
        this.suite = suite;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city of user location
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode of user location
     */
    public void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return geo
     */
    public Geo getGeo() {
        return geo;
    }

    /**
     * @param geo object of lng and lit
     */
    public void setGeo(final Geo geo) {
        this.geo = geo;
    }
}
