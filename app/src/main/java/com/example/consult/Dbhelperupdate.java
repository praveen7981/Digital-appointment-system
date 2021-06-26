package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelperupdate extends SQLiteOpenHelper {
    public Dbhelperupdate( Context context) {
        super(context, "appinformation.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE apps(id TEXT,name TEXT,problem,date TEXT,app TEXT PRIMARY KEY DEFAULT 0)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS apps");

    }
    public boolean saveapps(String id,String name,String problem,String date,String app)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("problem",problem);
        cv.put("date",date);
        cv.put("app",app);

        Long result=db.insert("apps",null,cv);

        if(result==-1)
        {
            return false;

        }
        else
        {
            return true;
        }

    }
    public Cursor retr()
    {
        SQLiteDatabase bg=this.getWritableDatabase();
        Cursor cr=bg.rawQuery("SELECT app from apps ORDER BY app desc LIMIT 1",null);
        return cr;
    }

}
