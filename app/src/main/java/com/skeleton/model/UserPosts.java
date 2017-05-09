package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by keshav on 9/5/17.
 */

public class UserPosts {

    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    /**
     * @return returns user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId user id
     */
    public void setUserId(final int userId) {
        this.userId = userId;
    }

    /**
     * @return returns id of the post
     */
    public int getId() {
        return id;
    }

    /**
     * @param id id of  the post
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the title of the post
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title of the post
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return body or content of the post
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body content of the post
     */
    public void setBody(final String body) {
        this.body = body;
    }
}
