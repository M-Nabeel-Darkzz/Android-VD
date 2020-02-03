package com.example.omdb_client.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "movie_table")

public class Movie implements Serializable {

    @PrimaryKey
    @SerializedName("imdbID")
    @ColumnInfo(name = "imdbID")
    private String imdbId;

    @SerializedName("Title")
    @ColumnInfo(name = "title")
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