package com.example.omdb_client.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.omdb_client.R;
import com.example.omdb_client.adapters.MovieAdapter;
import com.example.omdb_client.apis.Api;
import com.example.omdb_client.models.MovieItem;
import com.example.omdb_client.models.Movie;
import com.example.omdb_client.repositories.MovieRepository;
import com.example.omdb_client.utilities.ToastUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        repository = new MovieRepository(getApplication());
        if (repository.getAllMovies().size() > 0) {
            setDataInRecyclerView(repository.getAllMovies());
        } else
            getMovieList();
    }

    private void getMovieList(){

        Api.getMovie().search().enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                setDataInRecyclerView(response.body().search);
                repository.insert(response.body().search);
            }

            @Override
            public void onFailure(Call<MovieItem> call, Throwable t) {
                ToastUtil.toastLong(MainActivity.this, t.toString());
            }
        });
    }

    private void setDataInRecyclerView(List<Movie> movieListData) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        MovieAdapter moviesAdapter = new MovieAdapter(this, movieListData);
        recyclerView.setAdapter(moviesAdapter);
    }

}