package com.example.intentcodingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class GameResult extends AppCompatActivity {
    private GameResultPresenter GRpresenter = new GameResultPresenter();
    private int item;

    private TextView resultText;
    public static final String EXTRA_REPLY = "Winner";
    int count;
    private int firstItem;
    private int secondItem;
    private ImageView firstItemPic;
    private ImageView secondItemPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        Intent intent = getIntent();
        int firsPlayerItem = intent.getIntExtra(MainActivity.selectedItem,0);
        item = GRpresenter.selectWinner(firsPlayerItem);
        setResultGame(item);

        setItemsPic();
    }
    public void setItemsPic(){
        firstItemPic = findViewById(R.id.firstItemImg);
        secondItemPic = findViewById(R.id.secondItemImg);
        firstItem = GRpresenter.getFirstItem();
        secondItem = GRpresenter.getSecondItem();
        firstItemPic.setImageResource(firstItem);
        secondItemPic.setImageResource(secondItem);

    }

    public void setResultGame(int result){
        resultText = findViewById(R.id.resultText);
        if (result<0){
            resultText.setText("Проиграл!");
            count = -1;
        }

        if (result==0){
            resultText.setText("Ничья!");
            count = 0;
        }
        if (result>0){
            resultText.setText("Выиграл!");
            count = 1;
        }
    }

    public void returnReply(View view){
        Intent replyIntent = getIntent();

        replyIntent.putExtra(EXTRA_REPLY,count);
        setResult(RESULT_OK, replyIntent);
        finish();
    }


}