package com.example.foodapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 2)
public abstract class UserDatabaseClass extends RoomDatabase {
    private static UserDatabaseClass instance;

    public static synchronized UserDatabaseClass getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            UserDatabaseClass.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    public abstract UserDao getUserDao();
}
