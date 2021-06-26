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

public class DBHelperstdstatus extends SQLiteOpenHelper {
    public DBHelperstdstatus( Context context) {
        super(context, "nextopn.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase st) {
        st.execSQL("CREATE TABLE nextap(rownum INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT,name TEXT,app TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase st, int i, int i1) {
        st.execSQL("DROP TABLE IF EXISTS nextap");

    }
    public boolean apsave(String id,String name,String app)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("app",app);
        Long result=db.insert("nextap",null,cv);

        if (result==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
    public Cursor statusaap()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM nextap ORDER BY rownum desc LIMIT 1",null);
        return res;
    }



}
