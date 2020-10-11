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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Data.DatabaseHandler;
import Data.MainPresenter;
import KeyBoardFunc.KeyController;
import Model.LengthMeasures;
import Model.WeightMeasures;

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
        final Spinner toSpinner = findViewById(R.id.spinnerForEndValue);
        resultText = findViewById(R.id.labelResult);
//        DatabaseHandler db = new DatabaseHandler(this);
//        //        LengthMeasures deleteLM = db.getLengthMeasures(7);
//        db.addLengthMeasures(new LengthMeasures("Meter",1.0));
//        db.addLengthMeasures(new LengthMeasures("Inch",0.0254));
//        db.addLengthMeasures(new LengthMeasures("Foot",0.3048));
//        db.addLengthMeasures(new LengthMeasures("Yard",0.9144));
//        db.addLengthMeasures(new LengthMeasures("Perch",5.029));
//        db.addLengthMeasures(new LengthMeasures("Link",0.2011));
//        db.addLengthMeasures(new LengthMeasures("Mile",1600.4));
//
//        db.addWeightMeasures(new WeightMeasures("Kilogram",1.0));
//        db.addWeightMeasures(new WeightMeasures("Pound",0.453));
//        db.addWeightMeasures(new WeightMeasures("Ton",1016));
//        db.deleteLengthMeasure(deleteLM);
//        List<WeightMeasures> weightMeasuresList = db.getAllWeightMeasures();
//        for (WeightMeasures l: weightMeasuresList) {
//            String log = "ID: " + l.getId() + " NAME: " + l.getWeightName() + " COEF " + l.getWeigthCoefficientKilogram();
//            Log.d("NAME: ", log);
//        }


        List<String> lengthNames = presenter.getLengthNames();
        List<String> weightNames = presenter.getWeightNames();
        presenter.setLengthNames(lengthNames);
        presenter.setWeightNames(weightNames);
        List<String> namesList = new ArrayList<String>(lengthNames);
        namesList.addAll(weightNames);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inputValueText = findViewById(R.id.inputValue);
        fromSpinner.setAdapter(adapter);

        // ToDo продумать как исключать из второго спинера данные при выборе величины из одной категории
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                String nameInputMeasure = adapterView.getItemAtPosition(i).toString();
                presenter.setMeasureName(nameInputMeasure);
                double selectCoefByName = presenter.getMeasuresCoefMetr();
                presenter.setInputCoefCoef(selectCoefByName);
                if (presenter.getChangeAdapter()==null)
                {
                ArrayAdapter<String> adapterTo = presenter.getToAdapter(MainActivity.this);
                toSpinner.setAdapter(adapterTo);
                }
                if (presenter.getFlagLength()==true && presenter.getChangeAdapter()=="weight"){
                    ArrayAdapter<String> adapterTo = presenter.getToAdapter(MainActivity.this);
                    toSpinner.setAdapter(adapterTo);
                }
                if (presenter.getFlagWeight()==true && presenter.getChangeAdapter()=="length"){
                    ArrayAdapter<String> adapterTo = presenter.getToAdapter(MainActivity.this);
                    toSpinner.setAdapter(adapterTo);
                }




            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        presenter.setFlagLength(true);
//        ArrayAdapter<String> adapterTo = presenter.getToAdapter(this);
//        toSpinner.setAdapter(adapterTo);
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);
                String nameOutputMeasure = adapterView.getItemAtPosition(i).toString();
                presenter.setMeasureName(nameOutputMeasure);
                double selectCoefByName = presenter.getMeasuresCoefMetr();
                presenter.setOutputCoef(selectCoefByName);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
 public void calculateMeasure(View view){
        if (!inputValueText.getText().toString().equals("")) {

            double inputValue = Double.parseDouble(inputValueText.getText().toString());
            presenter.setValue(inputValue);
            double result = presenter.getTransformMeasure();

            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.CEILING);
            resultText.setText(df.format(result));
        }
 }

    public void doCopy(View view){
        this.clipboardManager = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("copy", resultText.getText());
        this.clipboardManager.setPrimaryClip(clipData);

    }

    public void editValue(View view){
        KeyController keyController = new KeyController(this);
        String resultText = keyController.writeNumber(inputValueText, (Button) view);
        inputValueText.setText(resultText);
    }

    public void deleteValue(View view){
        KeyController keyController = new KeyController(this);
        String resultText = keyController.deleteNumber(inputValueText);
        inputValueText.setText(resultText);
    }
}