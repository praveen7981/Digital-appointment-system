package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;

public class DBstudent_info extends SQLiteOpenHelper {
    public DBstudent_info( Context context)
    {
        super(context, "stud_info.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create Table stud_info(studId TEXT PRIMARY KEY,name TEXT,problem TEXT,date TEXT,Appoint_no INTEGER DEFAULT 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop Table if exists stud_info");
    }
    public Boolean insertdata(String studId, String name, String problem, SimpleDateFormat date, String ap_no)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("studentId",studId);
        contentValues.put("name",name);
        contentValues.put("problem",problem);
        contentValues.put("date", String.valueOf(date));
        contentValues.put("ap_no",ap_no);
        Long result=db.insert("Stud_info",null,contentValues);

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
