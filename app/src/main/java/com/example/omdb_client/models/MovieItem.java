package com.example.omdb_client.models;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieItem {

    // S capital because of response
    @Nullable
    @SerializedName("Search")
    public List<Movie> search;

}
