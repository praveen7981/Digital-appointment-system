package com.example.consult;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperdoctorfetch extends SQLiteOpenHelper {
    public DBHelperdoctorfetch( Context context) {
        super(context, "docfetch.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE docre(id TEXT,name TEXT,problem TEXT,date TEXT PRIMARY KEY,app TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS docre");

    }
    public boolean savedoc(String id,String name,String problem,String date,String app)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("name",name);
        cv.put("problem",problem);
        cv.put("date",date);
        cv.put("app",app);

        Long result=db.insert("docre",null,cv);

        if(result==-1)
        {
            return false;

        }
        else
        {
            return true;
        }

    }
    public Cursor allapp(String date)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor p=db.rawQuery("SELECT * FROM docre WHERE date=?",new String[]{date});
        return p;
    }

}
