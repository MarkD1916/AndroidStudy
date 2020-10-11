package Data;

import android.content.Context;
import android.view.textclassifier.TextClassifierEvent;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;

import com.example.meterstoinches.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.LengthMeasures;
import Model.WeightMeasures;

public class MainPresenter {
private Context ctx;
private double inputCoef;
private double outputCoef;
private String measureName;
private Double value;
private List<String> lengthNames;
private List<String> weightNames;
private  Boolean flagWeight;
private Boolean flagLength;
private String changeAdapter;

    public String getChangeAdapter() {
        return changeAdapter;
    }

    public void setChangeAdapter(String changeAdapter) {
        this.changeAdapter = changeAdapter;
    }

    public void setMeasureName(String measureName) {
        this.measureName = measureName;
    }

    public void setLengthNames(List<String> lengthNames) {
        this.lengthNames = lengthNames;
    }

    public void setWeightNames(List<String> weightNames) {
        this.weightNames = weightNames;
    }

    public void setFlagLength(Boolean flagLength) {
        this.flagLength = flagLength;
    }

    public List<String> getLengthNames() {
        DatabaseHandler db = new DatabaseHandler(ctx);
        lengthNames = db.getAllLengthMeasuresName();
        return lengthNames;
    }

    public Boolean getFlagWeight() {
        return flagWeight;
    }

    public Boolean getFlagLength() {
        return flagLength;
    }

    public List<String> getWeightNames() {
        DatabaseHandler db = new DatabaseHandler(ctx);
        weightNames = db.getAllWeightMeasureName();
        return weightNames;
    }



    public MainPresenter(Context ctx, String measureName) {
        this.measureName = measureName;
        this.ctx = ctx;
    }

    public MainPresenter(Context ctx) {
        this.ctx = ctx;
    }

    public MainPresenter(double coef) {
        this.inputCoef = coef;
    }

    public MainPresenter() {
    }

    public double getInputCoefCoef() {
        return inputCoef;
    }

    public void setInputCoefCoef(double coef) {
        this.inputCoef = coef;
    }

    public Double getValue() {
        return value;
    }

    public double getOutputCoef() {
        return outputCoef;
    }

    public void setOutputCoef(double outputCoef) {
        this.outputCoef = outputCoef;
    }

    public void setValue(Double value) {
        this.value = value;
    }


    public double getMeasuresCoefMetr(){
        DatabaseHandler db = new DatabaseHandler(ctx);
        flagWeight = weightNames.contains(measureName);
        flagLength =lengthNames.contains(measureName);
        Double coef =null;
        if (flagWeight){
            WeightMeasures selectCoefByName = db.getWeightMeasuresCoefKilogramByName(measureName);
            coef = selectCoefByName.getWeigthCoefficientKilogram();
        }
        if (flagLength){
            LengthMeasures selectCoefByName = db.getLengthMeasuresCoefMetrByName(measureName);
            coef = selectCoefByName.getLengthCoefficient();
        }
        return coef;
    }

    public double getTransformMeasure(){
        double transformMeasureFrom = (inputCoef * value)/outputCoef;
        return transformMeasureFrom;
    }

    public ArrayAdapter<String> getToAdapter(Context ctx){
        ArrayAdapter<String> adapter = null;
        if (flagLength) {
            adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, lengthNames);
            changeAdapter = "length";
        }
        if (flagWeight){
           adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, weightNames);
           changeAdapter = "weight";
        }
        return adapter;
    }


}
