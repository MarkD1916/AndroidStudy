package com.example.sleeepwalkersdiary.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sleeepwalkersdiary.Models.Nigth;

import java.util.List;

@Dao
public interface NigthDao {
    @Query("Select * from nigth")
    List<Nigth> getNigthlist();
    @Insert
    void insertNigth(Nigth nigth);
    @Update
    void updateNigth(Nigth nigth);
    @Delete
    void deleteNigth(Nigth nigth);
}
