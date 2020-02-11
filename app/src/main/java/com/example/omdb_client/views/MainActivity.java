package com.example.omdb_client.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.omdb_client.R;
import com.example.omdb_client.adapters.MovieAdapter;
import com.example.omdb_client.interfaces.MyCallback;
import com.example.omdb_client.models.Movie;
import com.example.omdb_client.repositories.MovieRepository;
import com.example.omdb_client.viewmodels.MovieViewModel;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        MovieViewModel movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.getMovies().observe(this, this::setDataInRecyclerView);
        }


    private void setDataInRecyclerView(List<Movie> movieListData) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MovieAdapter moviesAdapter = new MovieAdapter(this, movieListData);
        recyclerView.setAdapter(moviesAdapter);
    }

}