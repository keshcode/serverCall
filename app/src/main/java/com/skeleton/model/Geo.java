package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * geo
 */
public class Geo {
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;

    /**
     * @return lat of location
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat of location
     */
    public void setLat(final String lat) {
        this.lat = lat;
    }

    /**
     * @return lng of user
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng of user
     */
    public void setLng(final String lng) {
        this.lng = lng;
    }
}
