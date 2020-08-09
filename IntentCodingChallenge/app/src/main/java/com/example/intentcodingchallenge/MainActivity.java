package com.example.intentcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String selectedItem = "Item";


    private Intent makeChoice;

    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectShear(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedItem,0);
        startActivity(makeChoice);
    }

    public void selectStone(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedItem,1);
        startActivity(makeChoice);

    }

    public void selectPaper(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedItem,2);
        startActivity(makeChoice);

    }
}