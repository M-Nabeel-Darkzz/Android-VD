package com.example.omdb_client.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.omdb_client.models.Movie;
import com.example.omdb_client.repositories.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;
    private MutableLiveData<List<Movie>> allMovies;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
    }

    public LiveData<List<Movie>> getMovies() {
        if (allMovies == null) {
            allMovies = new MutableLiveData<>();
            loadMovies();
        }
        return allMovies;
    }

    private void loadMovies() {
        movieRepository.getMovieList(movies -> allMovies.setValue(movies));
    }
}