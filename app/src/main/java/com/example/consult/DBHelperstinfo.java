package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperstinfo extends SQLiteOpenHelper {

    public DBHelperstinfo(Context context) {
        super(context, "patientsinfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase patient) {
        patient.execSQL("create table patient(id TEXT primary key,name TEXT,problem TEXT,date TEXT,app TEXT DEFAULT 0,time Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase patient, int i, int i1) {
        patient.execSQL("DROP TABLE IF EXISTS patients ");

    }


    public boolean savapatient(String id, String name, String problem, String date, String app, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("name", name);
        cv.put("problem", problem);
        cv.put("date", date);
        cv.put("app", app);
        cv.put("time", time);

        long result = db.insert("patients", null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }
}
