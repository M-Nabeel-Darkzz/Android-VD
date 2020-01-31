package com.example.omdb_client.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omdb_client.R;
import com.example.omdb_client.models.Movie;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE_EXTRA = "movieObject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra(MOVIE_EXTRA);

        TextView tvTitle = findViewById(R.id.title_movieDetail);
        if (movie != null) {
            tvTitle.setText(movie.getTitle());

            TextView tvId = findViewById(R.id.imdbID_movieDetail);
            tvId.setText(movie.getImdbId());

            ImageView ivPoster = findViewById(R.id.ivMovieDetail);
            Picasso.with(this).load(movie.getPoster()).placeholder(R.drawable.android_placeholder).into(ivPoster);
        }
    }
}
