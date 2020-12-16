package com.example.sleeepwalkersdiary.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="nigth")
public class Nigth {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "attack")
    private String attack;
    @ColumnInfo(name = "attackType")
    private String attackType;
    @ColumnInfo(name = "amnesia")
    private String amnesia;
    @ColumnInfo(name = "headache")
    private String headache;
    @ColumnInfo(name = "sleepLength")
    private int sleepLength;
    @ColumnInfo(name = "date")
    private int date;

    public Nigth(int id, String attack, String headache) {
        this.id = id;
        this.attack = attack;
        this.headache = headache;
    }

}
