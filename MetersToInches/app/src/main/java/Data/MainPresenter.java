package Data;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.meterstoinches.MainActivity;

import java.util.List;

import Model.LengthMeasures;

public class MainPresenter {
private Context ctx;
private double inputCoef;
private double outputCoef;
private String measureName;
private Double value;

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

    public List<String> getMeasuresName(){

    DatabaseHandler db = new DatabaseHandler(ctx);
    List<String> lengthMeasuresNamesList = db.getAllLengthMeasuresName();
    return lengthMeasuresNamesList;

    }

    public double getMeasuresCoefMetr(){
        DatabaseHandler db = new DatabaseHandler(ctx);
        LengthMeasures selectCoefByName = db.getLengthMeasuresCoefMetrByName(measureName);
        inputCoef = selectCoefByName.getLengthCoefficient();
        return inputCoef;
    }

    public double getTransformMeasure(){
        double transformMeasureFrom = (inputCoef * value)/outputCoef;
        return transformMeasureFrom;
    }


}
