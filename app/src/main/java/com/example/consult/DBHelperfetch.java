package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DBHelperfetch extends SQLiteOpenHelper {
    public DBHelperfetch( Context context) {
        super(context, "fetch.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE fetch(id TEXT,name TEXT,problem TEXT,date TEXT PRIMARY KEY,app TEXT DEFAULT 0)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS fetch ");

    }

    public boolean saves(String id,String name,String problem,String date,String app)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("problem",problem);
        cv.put("date",date);
        cv.put("app",app);

        Long result=db.insert("fetch",null,cv);

        if(result==-1)
        {
            return false;

        }
        else
        {
            return true;
        }

    }
    public Cursor fetcha(String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM fetch WHERE date=?",new String[]{date});
        return res;
    }
}
