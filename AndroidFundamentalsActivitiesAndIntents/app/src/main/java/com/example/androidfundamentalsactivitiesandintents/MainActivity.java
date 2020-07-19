package com.example.androidfundamentalsactivitiesandintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Intent goToSecAct;

    private EditText mMessageEditText;
    private TextView mReplyText;
    public static final String EXTRA_MASSAGE = "Send";

    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyText = findViewById(R.id.text_reply);
    }

    public void launchSecondActivity (View view){
        //Log.d(LOG_TAG, "Button clicked!");
        String message = mMessageEditText.getText().toString();
        goToSecAct = new Intent(this,SecondActivity.class);
        goToSecAct.putExtra(EXTRA_MASSAGE,message);
        //startActivity(goToSecAct);
        startActivityForResult(goToSecAct,TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyText.setVisibility(View.VISIBLE);
                mReplyText.setText(reply);
            }
        }
    }
}