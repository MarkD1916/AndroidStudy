package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import Model.LengthMeasures;
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
                Util.KEY_LENGTH_COEFFICIENT + " REAL" + ")";
        db.execSQL(CREATE_LENGTH_MEASURES_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void addLengthMeasures(LengthMeasures length){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(Util.KEY_LENGTH_NAME,length.getLengthName());
        value.put(Util.KEY_LENGTH_COEFFICIENT, length.getLengthCoefficient());
        db.insert(Util.LENGTH_TABLE_NAME, null, value);
        db.close();
    }

    public LengthMeasures getLengthMeasures(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.LENGTH_TABLE_NAME, new String[] {Util.KEY_ID,Util.KEY_LENGTH_NAME,
        Util.KEY_LENGTH_COEFFICIENT}, Util.KEY_ID + "=?", new String[] {String.valueOf(id)},
                null,null,null,null);
        if (cursor!=null) {
            cursor.moveToFirst();
        }
        LengthMeasures selecedLengthMesures = new LengthMeasures(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), Integer.parseInt(cursor.getString(2)));
        return selecedLengthMesures;
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
                length.setLengthCoefficient(Integer.parseInt(cursor.getString(2)));
                lengthMeasuresList.add(length);
            } while (cursor.moveToNext());
        }
        return lengthMeasuresList;

    }
}
