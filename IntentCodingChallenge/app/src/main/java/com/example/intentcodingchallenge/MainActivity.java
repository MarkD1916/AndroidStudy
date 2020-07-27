package com.example.intentcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String selectedShear = "shear";
    public static final String selectedStone = "stone";
    public static final String selectedPaper = "paper";

    private Intent makeChoice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectShear(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedShear,1);
        startActivityForResult(makeChoice,1);
    }

    public void selectStone(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedStone,2);
        startActivityForResult(makeChoice,1);

    }

    public void selectPaper(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedPaper,3);
        startActivityForResult(makeChoice,1);

    }
}