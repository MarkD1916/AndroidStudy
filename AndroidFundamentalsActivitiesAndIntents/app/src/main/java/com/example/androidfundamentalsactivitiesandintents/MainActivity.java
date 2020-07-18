package com.example.androidfundamentalsactivitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private Intent goToSecAct;

    private EditText mMessageEditText;
    public static final String EXTRA_MASSAGE = "Send";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
    }

    public void launchSecondActivity (View view){
        //Log.d(LOG_TAG, "Button clicked!");
        String message = mMessageEditText.getText().toString();
        goToSecAct = new Intent(this,SecondActivity.class);
        goToSecAct.putExtra(EXTRA_MASSAGE,message);
        startActivity(goToSecAct);
    }

}