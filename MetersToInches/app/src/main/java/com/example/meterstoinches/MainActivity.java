package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Data.DatabaseHandler;
import Data.MainPresenter;
import Model.LengthMeasures;

public class MainActivity extends AppCompatActivity {
    private MainPresenter presenter = new MainPresenter(this);
    private TextView inputValueText;
    private ClipboardManager clipboardManager;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.setInputCoefCoef(1.0);
        presenter.setOutputCoef(1.0);
        Spinner fromSpinner = findViewById(R.id.spinnerForStartValue);
        Spinner toSpinner = findViewById(R.id.spinnerForEndValue);
        resultText = findViewById(R.id.labelResult);
//        DatabaseHandler db = new DatabaseHandler(this);
////        db.addLengthMeasures(new LengthMeasures("Meter",1.0));
////        LengthMeasures deleteLM = db.getLengthMeasures(7);
//        db.addLengthMeasures(new LengthMeasures("Inch",39.3701));
//        db.addLengthMeasures(new LengthMeasures("Foot",3.28084));
//        db.addLengthMeasures(new LengthMeasures("Yard",0.9144));
//        db.addLengthMeasures(new LengthMeasures("Perch",5.029));
//        db.addLengthMeasures(new LengthMeasures("link",0.2011));

//        db.deleteLengthMeasure(deleteLM);
//        List<LengthMeasures> lengthMeasuresList = db.getAllLengthMeasures();
//        for (LengthMeasures l: lengthMeasuresList) {
//            String log = "ID: " + l.getId() + " NAME: " + l.getLengthName() + " COEF " + l.getLengthCoefficient();
//            Log.d("NAME: ", log);
//        }


        List<String> lengthMeasuresNamesList = presenter.getMeasuresName();
//        for (String l: lengthMeasuresNamesList) {
//            String log = " NAME: " + l;
//            Log.d("NAME: ", log);
//        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lengthMeasuresNamesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputValueText = findViewById(R.id.inputValue);
        fromSpinner.setAdapter(adapter);
//        double inputStartValue = Double.parseDouble(inputValueText.getText().toString());


        //final String selectedMeasureName = fromSpinner.getSelectedItem().toString();
        //double selectCoefByName = presenter.getMeasuresCoefMetr(selectedMeasureName);
//        String log = " NAME: " + selectedMeasureName + " COEF: " + selectCoefByName;
//        Log.d("Result: ",log);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.d("Onitem: ",adapterView.getItemAtPosition(i).toString());
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                String nameInputMeasure = adapterView.getItemAtPosition(i).toString();
                MainPresenter presenterName = new MainPresenter(MainActivity.this,nameInputMeasure);
                double selectCoefByName = presenterName.getMeasuresCoefMetr();
                presenter.setInputCoefCoef(selectCoefByName);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        toSpinner.setAdapter(adapter);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                String nameOutputMeasure = adapterView.getItemAtPosition(i).toString();
                MainPresenter presenterName = new MainPresenter(MainActivity.this,nameOutputMeasure);
                double selectCoefByNameOutput = presenterName.getMeasuresCoefMetr();
                presenter.setOutputCoef(selectCoefByNameOutput);
                TextView outputValueText = findViewById(R.id.inputValue);
//                double outputValue = Double.parseDouble(outputValueText.getText().toString());
//                presenter.setValue(outputValue);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
 public void calculateMeasure(View view){
        double inputValue = Double.parseDouble(inputValueText.getText().toString());
        presenter.setValue(inputValue);
        double result =  presenter.getTransformMeasure();

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        resultText.setText(df.format(result));
 }

    public void doCopy(View view){
        this.clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("Some label", resultText.getText());
        this.clipboardManager.setPrimaryClip(clipData);

    }


}