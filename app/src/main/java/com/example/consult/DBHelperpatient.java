package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperpatient extends SQLiteOpenHelper {
    public DBHelperpatient( Context context) {
        super(context, "patient.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table patients(id TEXT primary key,name TEXT,problem TEXT,date TEXT,app TEXT,time TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists patients");

    }

    public boolean save(String id,String name,String problem,String date,String app,String time)
    {
        SQLiteDatabase dbp=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("problem",problem);
        cv.put("date",date);
        cv.put("app",app);
        cv.put("time",time);

        Long result=dbp.insert("patients",null,cv);

        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
