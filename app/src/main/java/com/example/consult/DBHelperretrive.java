package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperretrive extends SQLiteOpenHelper {
    public DBHelperretrive( Context context) {
        super(context, "search.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE re(id TEXT,name TEXT,problem TEXT,date TEXT,app TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS re");

    }



    public boolean savesdata(String id,String name,String problem,String date,String app)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("problem",problem);
        cv.put("date",date);
        cv.put("app",app);

        Long result=db.insert("re",null,cv);

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
