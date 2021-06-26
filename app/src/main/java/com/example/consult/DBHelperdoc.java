package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperdoc extends SQLiteOpenHelper {
    public DBHelperdoc( Context context)
    {
        super(context,"Doctor.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create Table user(username Text primary key,password Text,firstname Text,lastname Text,phone Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop Table if exists user");
    }
    public Boolean dinsertdata(String username,String password,String firstname,String lastname,String phone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("firstname",firstname);
        contentValues.put("lastname",lastname);
        contentValues.put("phone",phone);
        long result = db.insert("user",null,contentValues);
        if(result== -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Boolean dcheckusername(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from user where username =?",new String[]{username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public Boolean dcheckusernamepassword(String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from user where username =? and password =?",new String[]{username,password});
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
