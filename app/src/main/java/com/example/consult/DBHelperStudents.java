package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperStudents extends SQLiteOpenHelper
{
    public DBHelperStudents( Context context)
    {
        super(context, "student_info.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb)
    {
        mydb.execSQL("create Table Student_info(student_id TEXT primary key,name TEXT,problem TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldVersion, int newVersion)
    {
        mydb.execSQL("drop Table if exists Student_info");
    }

    public Boolean insertdata(String studentId,String name,String problem )
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("studentId",studentId);
        contentValues.put("name",name);
        contentValues.put("problem",problem);
        Long result=mydb.insert("Students_info",null,contentValues);

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
