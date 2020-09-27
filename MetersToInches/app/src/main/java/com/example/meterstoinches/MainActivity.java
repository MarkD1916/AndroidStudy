package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Data.DatabaseHandler;
import Data.MainPresenter;
import Model.LengthMeasures;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //DatabaseHandler db = new DatabaseHandler(this);
        //LengthMeasures deleteLM = db.getLengthMeasures(1);
        //db.addLengthMeasures(new LengthMeasures("Mile",1609.3));
//        db.addLengthMeasures(new LengthMeasures("Furlong",201.17));
//        db.addLengthMeasures(new LengthMeasures("Chain",20.117));
//        db.addLengthMeasures(new LengthMeasures("Perch",5.029));
//        db.addLengthMeasures(new LengthMeasures("link",0.2011));

        //db.deleteLengthMeasure(deleteLM);
//        List<LengthMeasures> lengthMeasuresList = db.getAllLengthMeasures();
//        for (LengthMeasures l: lengthMeasuresList) {
//            String log = "ID: " + l.getId() + " NAME: " + l.getLengthName() + " COEF " + l.getLengthCoefficient();
//            Log.d("NAME: ", log);
//        }
        final MainPresenter presenter = new MainPresenter(this);

        List<String> lengthMeasuresNamesList = presenter.getMeasuresName();
//        for (String l: lengthMeasuresNamesList) {
//            String log = " NAME: " + l;
//            Log.d("NAME: ", log);
//        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lengthMeasuresNamesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner fromSpinner = findViewById(R.id.spinnerForStartValue);
        fromSpinner.setAdapter(adapter);
        //final String selectedMeasureName = fromSpinner.getSelectedItem().toString();
        //double selectCoefByName = presenter.getMeasuresCoefMetr(selectedMeasureName);
//        String log = " NAME: " + selectedMeasureName + " COEF: " + selectCoefByName;
//        Log.d("Result: ",log);
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Onitem: ",adapterView.getItemAtPosition(i).toString());
                String name = adapterView.getItemAtPosition(i).toString();
                MainPresenter presenterName = new MainPresenter(MainActivity.this,name);
                double selectCoefByName = presenterName.getMeasuresCoefMetr();
                presenter.setCoef(selectCoefByName);
                TextView inputValueText = findViewById(R.id.inputValue);
                double inputValue = Double.parseDouble(inputValueText.getText().toString());
                presenter.setValue(inputValue);
                double transformMeasureValue = presenter.getTransformMeasure();
                Toast.makeText(getBaseContext(), "Position = " + transformMeasureValue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}