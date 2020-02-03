package com.example.omdb_client.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.omdb_client.R;
import com.example.omdb_client.models.Movie;
import com.example.omdb_client.views.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.omdb_client.views.MovieDetailActivity.MOVIE_EXTRA;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesViewHolder> {

    private Context context;
    private List<Movie> movieListData;

    public MovieAdapter(Context context, List<Movie> movieListData) {
        this.movieListData = movieListData;
        this.context = context;
    }

    @NonNull
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_list_items, parent, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MoviesViewHolder holder, final int position) {

        Movie movieItem = movieListData.get(position);
        // setting the data

        holder.title.setText(context.getString(R.string.title_recyclerView, movieItem.getTitle()));
        holder.imdbId.setText(context.getString(R.string.imdbID_recyclerView, movieItem.getImdbId()));
        Picasso.with(context).load(movieItem.getPoster()).placeholder(R.drawable.android_placeholder).into(holder.poster);

        // set onClickListener on itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display movie detail activity
                Movie movie = movieListData.get(position);
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra(MOVIE_EXTRA, movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieListData.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {

        TextView title, imdbId;
        ImageView poster;

        private MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            // get the reference of items
            title = itemView.findViewById(R.id.title);
            imdbId = itemView.findViewById(R.id.shortDescription);
            poster = itemView.findViewById(R.id.ivMovieIcon);

        }
    }

}
