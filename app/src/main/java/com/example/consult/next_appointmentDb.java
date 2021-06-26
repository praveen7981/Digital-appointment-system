package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class next_appointmentDb extends SQLiteOpenHelper {
    public next_appointmentDb( Context context) {
        super(context, "apstatus.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE op(id TEXT PRIMARY KEY,name TEXT,num TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists op");

    }
    public boolean insertapp(String id,String name,String num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("app",num);
        long result=db.insert("op",null,cv);

        if(result == -1)
        {
            return false;
        }
        else
        {
            return  true;
        }
    }

}
