package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class searchid extends AppCompatActivity {
    DBHelperretrive app;
    DBHelperreview re;
    EditText t1;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchid);
        app=new DBHelperretrive(this);
        re=new DBHelperreview(this);
        t1=findViewById(R.id.find);
        e1=findViewById(R.id.search);
    }

    public void search(View view) {
        String currentdate = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault()).format(new Date());
       String a=e1.getText().toString();
        SQLiteDatabase db=getApplicationContext().openOrCreateDatabase("rev.db", Context.MODE_PRIVATE,null);
        Cursor cr=db.rawQuery("select * from revs where id=?",new String[]{a});

        StringBuffer buffer=new StringBuffer();
        if(cr.getCount()==0)
        {
            Toast.makeText(this, "Not Exist this Appointment ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cr.moveToNext())
            {
                buffer.append("id:"+cr.getString(0)+"\n");
                buffer.append("Name:"+cr.getString(1)+"\n");
                buffer.append("Problem:"+cr.getString(2)+"\n");
                buffer.append("Date of Registration:"+cr.getString(3)+"\n");
                buffer.append("Appointment No:"+cr.getString(4)+"\n\n");

            }
            t1.setText(buffer);
        }
    }
}

