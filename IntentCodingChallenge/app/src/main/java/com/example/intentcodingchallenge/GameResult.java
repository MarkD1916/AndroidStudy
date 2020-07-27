package com.example.intentcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameResult extends AppCompatActivity {
    private GameResultPresenter winner = new GameResultPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
    }
}