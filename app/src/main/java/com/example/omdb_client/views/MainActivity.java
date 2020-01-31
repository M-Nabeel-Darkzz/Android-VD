package com.example.omdb_client.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.omdb_client.R;
import com.example.omdb_client.adapters.MovieAdapter;
import com.example.omdb_client.apis.Api;
import com.example.omdb_client.models.MovieItem;
import com.example.omdb_client.models.Movie;
import com.example.omdb_client.utilities.ToastUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        getMovieList();
    }

    private void getMovieList(){

        Api.getMovie().search().enqueue(new Callback<MovieItem>() {
            @Override
            public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                setDataInRecyclerView(response.body().search);
            }

            @Override
            public void onFailure(Call<MovieItem> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
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