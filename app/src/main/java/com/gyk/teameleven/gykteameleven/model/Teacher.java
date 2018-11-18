package com.gyk.teameleven.gykteameleven.model;

import java.io.Serializable;

public class Teacher implements Serializable {
    private long id;
    private String name;
    private String surname;
    private long stars;
    private String favoriteTopics;
    private String description;
    private String photoUrl;
    private String email;
    private String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private long status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFavoriteTopics() {
        return favoriteTopics;
    }

    public void setFavoriteTopics(String favoriteTopics) {
        this.favoriteTopics = favoriteTopics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getStars() {

        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }
}
