package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class op_status extends AppCompatActivity {
TextView t1;
    Timer timer;
    DBHelperstdstatus apps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op_status);
        t1=findViewById(R.id.appoint);
        apps=new DBHelperstdstatus(this);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i= new Intent(op_status.this,page2.class);
                startActivity(i);
                finish();

            }
        },5000);
    }

    public void status(View view) {
        Cursor cr=apps.statusaap();

        StringBuffer buffer=new StringBuffer();
        if(cr.getCount()==0)
        {
            Toast.makeText(this, "Not Exist Next Appointment number Details ", Toast.LENGTH_SHORT).show();
        }
        else
        {
           while (cr.moveToNext())
           {
               buffer.append("id:"+cr.getString(1)+"\n");
               buffer.append("Name:"+cr.getString(2)+"\n");
               buffer.append("Appointment No:"+cr.getString(3)+"\n");
           }
           t1.setText(buffer);
        }
    }
}
