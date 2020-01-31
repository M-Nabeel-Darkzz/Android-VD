package com.example.omdb_client.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("imdbID")
    private String imdbId;

    @SerializedName("Title")
    private String title;

    @SerializedName("Poster")
    private String poster;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}