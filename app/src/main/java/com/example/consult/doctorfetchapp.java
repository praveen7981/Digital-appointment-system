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

public class doctorfetchapp extends AppCompatActivity {
    EditText e1;
    DBHelperdoctorfetch kk;
    DBHelperreview re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorfetchapp);

        re=new DBHelperreview(this);

        kk=new DBHelperdoctorfetch(this);

        e1=findViewById(R.id.fetchall);
    }

    public void fetchall(View view) {
        String a= new SimpleDateFormat("dd-mm-yyy", Locale.getDefault()).format(new Date());
        SQLiteDatabase db=getApplicationContext().openOrCreateDatabase("rev.db", Context.MODE_PRIVATE,null);
        Cursor cr=db.rawQuery("select * from revs",null);


        StringBuffer buffer=new StringBuffer();
        if(cr.getCount()==0)
        {
            Toast.makeText(this, "Not Exist this Appointments ", Toast.LENGTH_SHORT).show();
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
            e1.setText(buffer);
        }
    }
}
