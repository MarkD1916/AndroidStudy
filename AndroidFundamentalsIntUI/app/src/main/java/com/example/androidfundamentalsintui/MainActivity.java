package com.example.androidfundamentalsintui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toast exToast;
    private Toast zeroToast;
    private int mCount=0;
    private TextView mShowCount;
    private Button zeroBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.showCount);
        zeroBut = findViewById(R.id.zeroBut);
    }

    public void showToast(View view){
        exToast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
        exToast.show();

    }

    public void countUp(View view){
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if (mCount>0){
            zeroBut.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
            //zeroBut.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));
    }

    public void zeroCount(View view){
        if (mCount==0){
            zeroToast = Toast.makeText(this, "It's already zero",Toast.LENGTH_SHORT);
            zeroToast.show();
        }
        mCount=0;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
            zeroBut.setBackgroundColor(getResources().getColor(R.color.lightgray));
    }
}