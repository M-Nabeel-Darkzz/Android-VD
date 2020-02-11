package com.example.omdb_client.repositories;

import android.app.Application;

import com.example.omdb_client.apis.Api;
import com.example.omdb_client.databases.MovieRoomDatabase;
import com.example.omdb_client.interfaces.MovieDao;
import com.example.omdb_client.interfaces.MyCallback;
import com.example.omdb_client.models.Movie;
import com.example.omdb_client.models.MovieItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MovieDao mMovieDao;
    private List<Movie> mAllMovies;
    private List<Movie> movieData;

    public MovieRepository(Application application) {
        MovieRoomDatabase db = MovieRoomDatabase.getDatabase(application);
        mMovieDao = db.movieDao();
        mAllMovies = mMovieDao.getMovieList();
    }

    public void getMovieList(final MyCallback callback){

        Api.getMovie().search().enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                callback.onData(response.body().search);
                movieData = response.body().search;
                deleteAll();
                insert(movieData);
            }

            @Override
            public void onFailure(Call<MovieItem> call, Throwable t) {
                callback.onData(getAllMovies());
                movieData = getAllMovies();
            }
        });
    }

    private List<Movie> getAllMovies() {
        return mAllMovies;
    }

    private void deleteAll() { mMovieDao.deleteAll(); }

    private void insert(List<Movie> movie) {
        mMovieDao.insert(movie);
    }
}
