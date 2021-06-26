package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Admin_staf extends SQLiteOpenHelper
{
    public Admin_staf( Context context) {
        super(context,"timetable.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user(date Text PRIMARY KEY,PP BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public boolean save(byte[] pp)
    {
        try
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("date",getDate());
            cv.put("pp",pp);
            db.insert("user",null,cv);
            return true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }
    public byte[] get()
    {
        String currentdate= new SimpleDateFormat("dd,mm,yyy", Locale.getDefault()).format(new Date());
        try
        {
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery("SELECT pp FROM user where date=?",new String[]{getDate()});
            if(cursor.moveToLast())
            {
                return cursor.getBlob(0);
            }
            return null;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    private String getDate()
    {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        Date date=new Date();
        return dateFormat.format(date);
    }




}
