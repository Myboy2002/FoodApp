package com.example.foodapp.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);
    @Query("SELECT * FROM User where email= :mail and password= :password")
    User getUser(String mail, String password);

}