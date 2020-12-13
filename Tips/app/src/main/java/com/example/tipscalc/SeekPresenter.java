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
    private float bill;

    private int smoothnessFactor = 10;

    private Context ctx;

    public SeekPresenter() {
    }

    public SeekPresenter(TextView seekValue, int seekStopValue) {
        this.seekValue = seekValue;
        this.seekStopValue = seekStopValue;
    }

    public SeekPresenter(Context ctx, SeekBar seekBar, TextView seekValue, TextView enterdBill, TextView resultTextView) {
        this.ctx = ctx;
        this.seekBar = seekBar;
        this.seekValue = seekValue;
        this.enterdBill = enterdBill;
        this.resultTextView = resultTextView;
    }

    public void setProgress(int progressValue){
        seekBar.setProgress(progressValue);
        seekStopValue = seekBar.getProgress();
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
            }
        });

    }
    public boolean calculateResult(){
            float result = 0.0f;
            boolean closekeyBoard;

            if (!enterdBill.getText().toString().equals("")){
                bill = Float.parseFloat(enterdBill.getText().toString());
                result = (float) (bill * Integer.parseInt(String.valueOf(seekStopValue))*0.001);
                resultTextView.setText("Tips: " + String.valueOf(result) + " $");
                closekeyBoard = true;

            }
            else{
                Toast.makeText(ctx,"Please enter a bill amount", Toast.LENGTH_LONG).show();
                closekeyBoard = false;
            }
        return closekeyBoard;
    }
}
