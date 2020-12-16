package com.example.tipscalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.tipscalc.KeyBoardFunc.KeyController;

import java.util.ArrayList;
import java.util.List;

import Adapters.ButtonAdapter;
import Models.PercentageButtons;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText enterBill;
    private TextView tipPercentage;
    private TextView resultTextView;
    private TextView seekValue;
    private Button calcButton;
    private SeekBar seekBar;

    private List<PercentageButtons> btns;
    private PercentageButtons percentageButtons;
    private SeekPresenter seekPresenter;

    mainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = findViewById(R.id.percentageVariant);
        model = new ViewModelProvider(this).get(mainActivityViewModel.class);

        enterBill = findViewById(R.id.enterBillTextView);
        tipPercentage = findViewById(R.id.tipPercentage);
        seekValue = findViewById(R.id.seekValue);
        resultTextView = findViewById(R.id.resultTextView);
        calcButton = findViewById(R.id.calcButton);
        seekBar = findViewById(R.id.seekBar);

        seekPresenter = new SeekPresenter(this,seekBar,seekValue,enterBill,resultTextView,model);
        btns = new ArrayList<>();
        for (int i = 5; i <= 20; i = i + 5) {
            percentageButtons = new PercentageButtons(String.valueOf(i) + " %", i*10,seekPresenter);
            btns.add(percentageButtons);
        }
        ListAdapter adapter = new ButtonAdapter(this,btns);
        gridview.setAdapter(adapter);


        resultTextView.setText(seekPresenter.getCurrentResult());
        enterBill.setText(seekPresenter.getCurrentBill());

    }

    @Override
    public void onClick(View view){
        boolean closeFlag = seekPresenter.closeKeyBoard();
        if (closeFlag) {
            float resultTips = seekPresenter.calcResult();
            InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(this.INPUT_METHOD_SERVICE);
            resultTextView.setText("Tips: " + String.valueOf(resultTips) + " $");
            try {
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            } catch (Exception e) {
                e.printStackTrace();

            }


        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        enterBill.setTransformationMethod(new PasswordTransformationMethod());
        enterBill.setTransformationMethod(null);
        calcButton.setOnClickListener(this);
        seekPresenter.setSeekBarListener();
    }

    public void editValue(View view){
        KeyController keyController = new KeyController(this);
        String resultText = keyController.writeNumber(enterBill, (Button) view);
        enterBill.setText(resultText);
    }

    public void deleteValue(View view){
        KeyController keyController = new KeyController(this);
        String resultText = keyController.deleteNumber(enterBill);
        enterBill.setText(resultText);
    }
}