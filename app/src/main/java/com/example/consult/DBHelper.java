package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context)
    {
        super(context,"Administration.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb)
    {
      mydb.execSQL("create Table users(username Text primary key,password Text,firstname Text,lastname Text,phone Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldVersion, int newVersion)
    {
        mydb.execSQL("drop Table if exists users");

    }
    public Boolean insertdata(String username,String password,String firstname,String lastname,String phone)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("phone",phone);
        long result = mydb.insert("users",null,contentValues);
        if(result== -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Boolean checkusername(String username)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor= mydb.rawQuery("select * from users where username =?",new String[]{username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean checkusernamepassword(String username,String password)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        Cursor cursor= mydb.rawQuery("select * from users where username =? and password =?",new String[]{username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
