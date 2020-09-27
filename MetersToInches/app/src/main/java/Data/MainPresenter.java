package Data;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.meterstoinches.MainActivity;

import java.util.List;

import Model.LengthMeasures;

public class MainPresenter {
private Context ctx;
private double coef;
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
        this.coef = coef;
    }

    public MainPresenter() {
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public Double getValue() {
        return value;
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
        coef = selectCoefByName.getLengthCoefficient();
        return coef;
    }

    public double getTransformMeasure(){
        double transformMeasure = coef * value;
        return transformMeasure;
    }

}
