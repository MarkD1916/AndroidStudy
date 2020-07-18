package com.example.androidfundamentalsactivitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "Reply";
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String massege = intent.getStringExtra(MainActivity.EXTRA_MASSAGE);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(massege);


    }

    public void returnReply(View view){
        mReply = findViewById(R.id.editText_reply);
        Intent replyIntent = getIntent();
        String reply = mReply.getText().toString();

        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, replyIntent);
        finish();


    }


}