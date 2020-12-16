package com.example.tipscalc;

import android.widget.TextView;

import androidx.lifecycle.ViewModel;

public class mainActivityViewModel extends ViewModel {
    float result = 0.0f;
    float bill;
    int seekStopValue;

    public void setSeekStopValue(int seekStopValue) {
        this.seekStopValue = seekStopValue;
    }

    public float calcResult(TextView enterdBill){
        bill = Float.parseFloat(enterdBill.getText().toString());
        result = (float) (bill * Integer.parseInt(String.valueOf(seekStopValue))*0.001);
        return result;
    }

    public float getCurrentResule(){
        return result;
    }

    public float getEnterBill(){
        return bill;
    }

}
