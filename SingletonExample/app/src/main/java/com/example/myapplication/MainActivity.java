package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent goToSecondAct;
    private String message;
    private TextView firstMessageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstMessageTV = findViewById(R.id.Message1);
        Singleton ms = Singleton.getInstance();
        message = ms.getVariable();
        firstMessageTV = findViewById(R.id.Message1);
        firstMessageTV.setText(message);
    }

    public void secondAct(View view){

        goToSecondAct = new Intent(this,MainActivity2.class);
        startActivityForResult(goToSecondAct,1);

    }
}