package Data;

import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import Model.LengthMeasures;
import Model.WeightMeasures;
import Utils.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LENGTH_MEASURES_TABLE = "CREATE TABLE " + Util.LENGTH_TABLE_NAME + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY," +
                Util.KEY_LENGTH_NAME + " TEXT," +
                Util.LENGTH_COEFFICIENT_METR + " REAL" + ")";
        String CREATE_WEIGHT_MEASURES_TABLE = "CREATE TABLE " + Util.WEIGHT_TABLE_NAME + "(" +
                Util.KEY_ID + " INTEGER PRIMARY KEY," +
                Util.KEY_WEIGHT_NAME + " TEXT," +
                Util.WEIGHT_COEFFICIENT_KILOGRAM + " REAL" + ")";
        db.execSQL(CREATE_LENGTH_MEASURES_TABLE);
        db.execSQL(CREATE_WEIGHT_MEASURES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addLengthMeasures(LengthMeasures length){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Util.KEY_LENGTH_NAME,length.getLengthName());
        value.put(Util.LENGTH_COEFFICIENT_METR, length.getLengthCoefficient());
        db.insert(Util.LENGTH_TABLE_NAME, null, value);
        db.close();
    }
    public void addWeightMeasures(WeightMeasures weight){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Util.KEY_WEIGHT_NAME,weight.getWeightName());
        value.put(Util.WEIGHT_COEFFICIENT_KILOGRAM, weight.getWeigthCoefficientKilogram());
        db.insert(Util.WEIGHT_TABLE_NAME, null, value);
        db.close();
    }


    public LengthMeasures getLengthMeasures(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.LENGTH_TABLE_NAME, new String[] {Util.KEY_ID,Util.KEY_LENGTH_NAME,
        Util.LENGTH_COEFFICIENT_METR}, Util.KEY_ID + "=?", new String[] {String.valueOf(id)},
                null,null,null,null);
        if (cursor!=null) {
            cursor.moveToFirst();
        }
        return new LengthMeasures(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), Double.parseDouble(cursor.getString(2)));
    }

    public LengthMeasures getLengthMeasuresCoefMetrByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.LENGTH_TABLE_NAME, new String[] {Util.KEY_LENGTH_NAME,
                        Util.LENGTH_COEFFICIENT_METR}, Util.KEY_LENGTH_NAME + "=?", new String[] {name},
                null,null,null,null);
        if (cursor!=null) {
            cursor.moveToFirst();
        }
        return new LengthMeasures(
                cursor.getString(0), Double.parseDouble(cursor.getString(1)));
    }

    public WeightMeasures getWeightMeasuresCoefKilogramByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.WEIGHT_TABLE_NAME, new String[] {Util.KEY_WEIGHT_NAME,
                        Util.WEIGHT_COEFFICIENT_KILOGRAM}, Util.KEY_WEIGHT_NAME + "=?", new String[] {name},
                null,null,null,null);
        if (cursor!=null) {
            cursor.moveToFirst();
        }
        return new WeightMeasures(
                cursor.getString(0), Double.parseDouble(cursor.getString(1)));
    }

    public List<LengthMeasures> getAllLengthMeasures(){
        SQLiteDatabase db = this.getReadableDatabase();
        List <LengthMeasures> lengthMeasuresList = new ArrayList<>();
        String selectAllLength = "SELECT * FROM " + Util.LENGTH_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllLength,null);
        if (cursor.moveToFirst()){
            do {
                LengthMeasures length = new LengthMeasures();
                length.setId(Integer.parseInt(cursor.getString(0)));
                length.setLengthName(cursor.getString(1));
                length.setLengthCoefficient(Double.parseDouble(cursor.getString(2)));
                lengthMeasuresList.add(length);
            } while (cursor.moveToNext());
        }
        return lengthMeasuresList;

    }

    public List<WeightMeasures> getAllWeightMeasures(){
        SQLiteDatabase db = this.getReadableDatabase();
        List <WeightMeasures> weightMeasuresList = new ArrayList<>();
        String selectAllWeights = "SELECT * FROM " + Util.WEIGHT_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllWeights, null);
        if (cursor.moveToFirst()){
            do{
                WeightMeasures weight = new WeightMeasures();
                weight.setId(Integer.parseInt(cursor.getString(0)));
                weight.setWeightName((cursor.getString(1)));
                weight.setWeigthCoefficientKilogram(Double.parseDouble((cursor.getString(2))));
                weightMeasuresList.add(weight);
            } while (cursor.moveToNext());
        }
        return weightMeasuresList;
    }

    public List<String> getAllLengthMeasuresName(){
        SQLiteDatabase db = this.getReadableDatabase();
        List <String> lengthMeasuresNameList = new ArrayList<>();
        String selectAllLengthNames = "SELECT " + Util.KEY_LENGTH_NAME + " FROM " + Util.LENGTH_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllLengthNames,null);
        if (cursor.moveToFirst()){
            do {
                LengthMeasures length = new LengthMeasures();
                length.setLengthName(cursor.getString(0));
                lengthMeasuresNameList.add(length.getLengthName());
            } while (cursor.moveToNext());
        }
        return lengthMeasuresNameList;
    }

    public List<String> getAllWeightMeasureName(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> weightMeasureNamesList = new ArrayList<>();
        String selectAllWeighNames = "SELECT " + Util.KEY_WEIGHT_NAME + " FROM " + Util.WEIGHT_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAllWeighNames, null);
        if (cursor.moveToFirst()){
            do {
                WeightMeasures weight = new WeightMeasures();
                weight.setWeightName(cursor.getString(0));
                weightMeasureNamesList.add(weight.getWeightName());
            } while(cursor.moveToNext());
        }
        return weightMeasureNamesList;
    }

    public int updateLengthMeasure(LengthMeasures length){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_LENGTH_NAME,length.getLengthName());
        values.put(Util.LENGTH_COEFFICIENT_METR,length.getLengthCoefficient());
        return db.update(Util.LENGTH_TABLE_NAME,values, Util.KEY_ID +"=?",
                new String[] {String.valueOf(length.getId())});

    }

    public void deleteLengthMeasure(LengthMeasures length){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.LENGTH_TABLE_NAME, Util.KEY_ID + "=?", new String[] {String.valueOf(length.getId())});
        db.close();
    }


}
