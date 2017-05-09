package com.skeleton.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.skeleton.util.Log;

/**
 * Created by keshav on 4/5/17.
 */

public class UserDetail implements Parcelable {

    public static final Creator<UserDetail> CREATOR = new Creator<UserDetail>() {
        @Override
        public UserDetail createFromParcel(final Parcel in) {
            return new UserDetail(in);
        }

        @Override
        public UserDetail[] newArray(final int size) {
            return new UserDetail[size];
        }
    };
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private Address address;
    @SerializedName("phone")
    private String phone;
    @SerializedName("website")
    private String website;
    @SerializedName("company")
    private Company company;

    /**
     * @param in in refernce to paracable
     */
    protected UserDetail(final Parcel in) {
        id = in.readInt();
        name = in.readString();
        username = in.readString();
        email = in.readString();
        phone = in.readString();
        website = in.readString();
    }

    /**
     * @return id
     */
    public int getId() {
        Log.d("debug", String.valueOf(id));
        return id;
    }

    /**
     * @param id sets id of user
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * sets name of user
     *
     * @param name name of user
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return usename
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email of user
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address of user
     */
    public void setAddress(final Address address) {
        this.address = address;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone of user
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website of user
     */
    public void setWebsite(final String website) {
        this.website = website;
    }

    /**
     * @return commany
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company of user
     */
    public void setCompany(final Company company) {
        this.company = company;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(website);
    }
}
