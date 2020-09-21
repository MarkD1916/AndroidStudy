package com.example.meterstoinches;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Data.DatabaseHandler;
import Model.LengthMeasures;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler db = new DatabaseHandler(this);

//        db.addLengthMeasures(new LengthMeasures("Proba1",2000));
//        db.addLengthMeasures(new LengthMeasures("Proba2",3000));
//        db.addLengthMeasures(new LengthMeasures("Proba3",4000));
//        db.addLengthMeasures(new LengthMeasures("Proba4",5000));
//        db.addLengthMeasures(new LengthMeasures("Proba5",6000));
//        db.addLengthMeasures(new LengthMeasures("Proba6",7000));
//        db.addLengthMeasures(new LengthMeasures("Proba7",8000));
        List<LengthMeasures> lengthMeasuresList = db.getAllLengthMeasures();
        for (LengthMeasures l: lengthMeasuresList){
            String log = "ID: " + l.getId() + " NAME: " + l.getLengthName() + " COEF " + l.getLengthCoefficient();
            Log.d("NAME: ", log);
        }
//        LengthMeasures Test = db.getLengthMeasures(1);
//        String log = "ID" + Test.getLengthName();
//        System.out.println(log);


    }
}