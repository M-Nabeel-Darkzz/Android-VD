package com.example.omdb_client.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.omdb_client.interfaces.MovieDao;
import com.example.omdb_client.models.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieRoomDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

    private static volatile MovieRoomDatabase INSTANCE;

    public static MovieRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (MovieRoomDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieRoomDatabase.class,
                            "movie_database").
                            allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
