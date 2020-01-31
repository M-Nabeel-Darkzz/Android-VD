package com.example.omdb_client.apis;

import com.example.omdb_client.interfaces.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://www.omdbapi.com/";

    public static ApiInterface getMovie() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ApiInterface.class);
    }
}
