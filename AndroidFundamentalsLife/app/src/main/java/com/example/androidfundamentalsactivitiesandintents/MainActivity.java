package com.example.androidfundamentalsactivitiesandintents;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent goToSecAct;

    private EditText mMessageEditText;
    private TextView mReplyText;
    public static final String EXTRA_MASSAGE = "Send";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyText = findViewById(R.id.text_reply);
        Log.d(LOG_TAG,"---------");
        Log.d(LOG_TAG,"onCreate");
        if (savedInstanceState!=null){

            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if (isVisible){
                mReplyText.setVisibility(View.VISIBLE);
                mReplyText.setText(savedInstanceState.getString("reply_text"));


            }
        }
    }

    public void launchSecondActivity (View view){
        String message = mMessageEditText.getText().toString();
        goToSecAct = new Intent(this,SecondActivity.class);
        goToSecAct.putExtra(EXTRA_MASSAGE,message);
        startActivityForResult(goToSecAct,TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TEXT_REQUEST){
            if (resultCode==RESULT_OK){
                if (data == null) {
                    throw new AssertionError();
                }
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyText.setVisibility(View.VISIBLE);
                mReplyText.setText(reply);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyText.getVisibility()==View.VISIBLE){
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_text",mReplyText.getText().toString());

        }

    }
}