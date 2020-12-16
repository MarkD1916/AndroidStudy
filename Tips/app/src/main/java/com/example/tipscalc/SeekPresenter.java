package com.example.tipscalc;

import android.content.Context;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekPresenter {

    private SeekBar seekBar;
    private TextView seekValue;
    private TextView enterdBill;
    private TextView resultTextView;

    private int seekStopValue;

    private int smoothnessFactor = 10;

    private Context ctx;

    mainActivityViewModel model;


    public SeekPresenter() {
    }

    public SeekPresenter(TextView seekValue, int seekStopValue) {
        this.seekValue = seekValue;
        this.seekStopValue = seekStopValue;
    }

    public SeekPresenter(Context ctx, SeekBar seekBar, TextView seekValue, TextView enterdBill, TextView resultTextView,mainActivityViewModel model) {
        this.ctx = ctx;
        this.seekBar = seekBar;
        this.seekValue = seekValue;
        this.enterdBill = enterdBill;
        this.resultTextView = resultTextView;
        this.model = model;
    }

    public void setProgress(int progressValue){
        seekBar.setProgress(progressValue);
        seekStopValue = seekBar.getProgress();
        model.setSeekStopValue(seekStopValue);
    }
    public void setSeekBarListener() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = Math.round(progress / smoothnessFactor);
                seekValue.setText(String.valueOf(progress)+" %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(Math.round((seekBar.getProgress() + (smoothnessFactor / 2)) / smoothnessFactor) * smoothnessFactor);
                seekStopValue = seekBar.getProgress();
                model.setSeekStopValue(seekStopValue);
            }
        });

    }
    public boolean closeKeyBoard(){
            boolean closekeyBoard;
            if (!enterdBill.getText().toString().equals("")){
                closekeyBoard = true;
            }
            else{
                Toast.makeText(ctx,"Please enter a bill amount", Toast.LENGTH_LONG).show();
                closekeyBoard = false;
            }
        return closekeyBoard;
    }

    public float calcResult(){
        float result = model.calcResult(enterdBill);
        return result;
    }

    public String getCurrentResult(){
        float currentResult = model.getCurrentResule();
        return "Tips: " + String.valueOf(currentResult)+" $";
    }

    public String getCurrentBill(){
        float currentBill = model.getEnterBill();
        if (currentBill==0.0){
            return "";
        }
        else{
            return String.valueOf(currentBill);
        }

    }



}
