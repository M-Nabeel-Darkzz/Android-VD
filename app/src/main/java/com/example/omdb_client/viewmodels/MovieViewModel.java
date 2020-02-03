package com.example.omdb_client.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.omdb_client.models.Movie;
import com.example.omdb_client.repositories.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository mRepository;

    private LiveData<List<Movie>> mAllMovies;

    public MovieViewModel(Application application) {
        super(application);
        mRepository = new MovieRepository(application);
        mAllMovies = mRepository.getAllMovies();
    }

    LiveData<List<Movie>> getAllMovies() { return mAllMovies; }

    public void insert(Movie movie) { mRepository.insert(movie); }
}
