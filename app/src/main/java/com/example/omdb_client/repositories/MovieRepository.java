package com.example.omdb_client.repositories;

import android.app.Application;

import com.example.omdb_client.databases.MovieRoomDatabase;
import com.example.omdb_client.interfaces.MovieDao;
import com.example.omdb_client.models.Movie;

import java.util.List;

public class MovieRepository {

    private MovieDao mMovieDao;
    private List<Movie> mAllMovies;

    public MovieRepository(Application application) {
        MovieRoomDatabase db = MovieRoomDatabase.getDatabase(application);
        mMovieDao = db.movieDao();
        mAllMovies = mMovieDao.getMovieList();
    }

    public List<Movie> getAllMovies() {
        return mAllMovies;
    }

    public void insert(List<Movie> movie) {
        mMovieDao.insert(movie);
    }
}
