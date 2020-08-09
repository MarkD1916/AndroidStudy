package com.example.intentcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameResult extends AppCompatActivity {
    private GameResultPresenter GRpresenter = new GameResultPresenter();
    private int test;
    private Toast zeroToast;
    private TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        Intent intent = getIntent();
        int firsPlayerItem = intent.getIntExtra(MainActivity.selectedItem,0);
        test = GRpresenter.selectWinner(firsPlayerItem);
        setResultGame(test);
    }

    public void setResultGame(int result){
        resultText = findViewById(R.id.resultText);
        if (result<0){
            resultText.setText("Проиграл!");
        }

        if (result==0){
            resultText.setText("Ничья!");
        }
        if (result>0){
            resultText.setText("Выиграл!");
        }
    }


}