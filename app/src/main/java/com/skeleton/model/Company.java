package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * company
 */
public class Company {
    @SerializedName("name")
    private String name;
    @SerializedName("catchPhrase")
    private String catchPhrase;
    @SerializedName("bs")
    private String bs;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name of user
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return catchPhrase
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * @param catchPhrase of user
     */
    public void setCatchPhrase(final String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * @return bs
     */
    public String getBs() {
        return bs;
    }

    /**
     * @param bs input
     */
    public void setBs(final String bs) {
        this.bs = bs;
    }
}
