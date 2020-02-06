package com.example.omdb_client.interfaces;

import com.example.omdb_client.models.Movie;

import java.util.List;

public interface MyCallback {

    void onData(List<Movie> movies);

}
