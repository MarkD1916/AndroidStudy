package com.example.intentcodingchallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String selectedItem = "Item";


    private Intent makeChoice;

    private MainPresenter presenter = new MainPresenter();

    public static final int TEXT_REQUEST = 1;



    private TextView firstPlayerCountLable;
    private TextView secondPlayerCountLable;

    private int reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectShear(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedItem,0);
        startActivityForResult(makeChoice,TEXT_REQUEST);
    }

    public void selectStone(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedItem,1);
        startActivityForResult(makeChoice,TEXT_REQUEST);

    }

    public void selectPaper(View view){
        makeChoice = new Intent(this,GameResult.class);
        makeChoice.putExtra(selectedItem,2);
        startActivityForResult(makeChoice,TEXT_REQUEST);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                if (data == null) {
                    throw new AssertionError();
                }
                reply = data.getIntExtra(GameResult.EXTRA_REPLY,0);
                firstPlayerCountLable = findViewById(R.id.playerOneCount);
                secondPlayerCountLable = findViewById(R.id.playerTwoCount);
                presenter.countScore(reply);
                firstPlayerCountLable.setText(String.valueOf(presenter.getCountFirstPlayer()));
                secondPlayerCountLable.setText(String.valueOf(presenter.getCountSecondPlayer()));
            }
        }
    }


}