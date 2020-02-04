package com.example.omdb_client.interfaces;

import com.example.omdb_client.models.MovieItem;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("/?s=dark&apikey=767d3a1")
    Call<MovieItem> search();

}
