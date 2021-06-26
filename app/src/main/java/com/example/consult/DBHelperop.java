package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelperop extends SQLiteOpenHelper {
    public DBHelperop( Context context) {
        super(context,"op.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("CREATE TABLE ops(idnum TEXT primary key,name TEXT,appnum TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase mydb, int i, int i1) {

        mydb.execSQL("drop table if exists ops");
    }

    public boolean insertop(String idnum,String name,String appnum)
    {
        SQLiteDatabase mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",idnum);
        contentValues.put("name",name);
        contentValues.put("num",appnum);

        long result=mydb.insert("ops",null,contentValues);

        if(result== -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
