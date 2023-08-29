package com.example.room_library;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenceDAO {

    @Query("SELECT * FROM expence")
    List<Expence> getAllExpence();

    @Insert
    void addData(Expence expence);

    @Update
    void updateData(Expence expence);

    @Delete
    void deleteData(Expence expence);

}
