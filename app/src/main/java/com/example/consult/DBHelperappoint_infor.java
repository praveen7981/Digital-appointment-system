package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperappoint_infor extends SQLiteOpenHelper {

    public DBHelperappoint_infor( Context context) {
        super(context, "studentappo.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase app) {
        app.execSQL("CREATE TABLE stdinfor(id Text PRIMARY KEY,name TEXT,problem TEXT,date TEXT,app TEXT DEFAULT 0)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase app, int i, int i1) {
        app.execSQL("DROP TABLE IF EXISTS stdinfor");

    }
    public boolean stdsave(String id, String name, String problem, String date, String app)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("problem",problem);
        cv.put("date",date);
        cv.put("app",app);

        long result=db.insert("stdinfor",null,cv);

        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor retrivelast()
    {
        SQLiteDatabase bg=this.getWritableDatabase();
        Cursor cr=bg.rawQuery("SELECT app FROM stdinfor ORDER BY id desc LIMIT 1",null);
        return cr;
    }
}
