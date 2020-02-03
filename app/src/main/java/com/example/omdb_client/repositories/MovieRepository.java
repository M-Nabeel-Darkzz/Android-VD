package com.example.omdb_client.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.omdb_client.databases.MovieRoomDatabase;
import com.example.omdb_client.interfaces.MovieDao;
import com.example.omdb_client.models.Movie;

import java.util.List;

public class MovieRepository {

    private MovieDao mMovieDao;
    private LiveData<List<Movie>> mAllMovies;

    public MovieRepository(Application application) {
        MovieRoomDatabase db = MovieRoomDatabase.getDatabase(application);
        mMovieDao = db.movieDao();
        mAllMovies = mMovieDao.getMovieList();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return mAllMovies;
    }

    public void insert(Movie movie) {
        mMovieDao.insert(movie);
    }
}
