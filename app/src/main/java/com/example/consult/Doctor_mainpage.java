package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Doctor_mainpage extends AppCompatActivity{
EditText name,id,temperature,disease,Nname,Nid,Napp;

Spinner tablets,count;
EditText t1,docname,docdisg;
Button bt;

DBHelperstdstatus  nextdb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_mainpage);
        nextdb=new DBHelperstdstatus(this);

        name=findViewById(R.id.pname);
        id=findViewById(R.id.pid);
        temperature=findViewById(R.id.temp);
        disease=findViewById(R.id.pdisease);
        t1=findViewById(R.id.list);
        tablets=findViewById(R.id.tablets);
        count=findViewById(R.id.count);
        bt=findViewById(R.id.submit_list);

        Nname=findViewById(R.id.nextname);
        Nid=findViewById(R.id.nextid);
        Napp=findViewById(R.id.nextapp);

    }

    public void add(View view)
    {
        String tablet=tablets.getSelectedItem().toString();
        String cou=count.getSelectedItem().toString();
        t1.append(tablet+"-->"+cou);
        t1.append(System.getProperty("line.separator"));

    }

    public void prescription(View view)
    {
        String nam=name.getText().toString();
        String Id=id.getText().toString();
        String temp=temperature.getText().toString();
        String prob=disease.getText().toString();
        String tab_list=t1.getText().toString();


        if(!nam.isEmpty()&&!Id.isEmpty()&&!temp.isEmpty()&&!prob.isEmpty()&&!tab_list.isEmpty())
        {
            t1.setText("Student name:"+nam);
            t1.append(System.getProperty("line.separator"));
            t1.append("Student Id:"+Id);
            t1.append(System.getProperty("line.separator"));
            t1.append("Temperature:"+temp);
            t1.append(System.getProperty("line.separator"));
            t1.append("Disease:"+prob);
            t1.append(System.getProperty("line.separator"));
            t1.append("Tablets:");
            t1.append(System.getProperty("line.separator"));
            t1.append(tab_list);
        }
        else
        {
            Toast.makeText(this, "Fill all the Fields", Toast.LENGTH_SHORT).show();
        }

    }

    public void pharmacy(View view)
    {
        String Id=id.getText().toString();
        String tab_list=t1.getText().toString();
        if(tab_list.isEmpty()&&!tab_list.contains("Student name")&&!tab_list.contains("Student Id")&&!tab_list.contains("Temperature")&&!tab_list.contains("Disease"))
        {
            Toast.makeText(this, "Enter all the Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {

            String pres=tab_list;
            Intent i = new Intent(Intent.ACTION_SEND_MULTIPLE);
            i.putExtra(i.EXTRA_EMAIL, new String[]{"praveenrelli123@gmail.com", "karthikrellirelli123@gmail.com", "s160992@rguktsklm.ac.in"});
            i.putExtra(i.EXTRA_SUBJECT, Id);
            i.putExtra(i.EXTRA_TEXT, pres);
            i.setType("message/rfc822");
            if (i.resolveActivity(getPackageManager()) != null) {
                startActivity(i);
            } else {
                Toast.makeText(this, "There is no application that suppourt this action", Toast.LENGTH_SHORT).show();
            }

        }

    }

    public void nextop(View view)
    {
        String name=Nname.getText().toString();
        String id=Nid.getText().toString();
        String app=Napp.getText().toString();

        if(!name.equals("")&&!id.equals("")&&!app.equals("")) {

            Boolean result = nextdb.apsave(id,name,app);
            if (result == false) {
                Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(this, "Update successfull", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Enter All the Fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void settings(View view) {
    }

    public void logout(View view) {
        Intent i=new Intent(Doctor_mainpage.this,page2.class);
        startActivity(i);
    }

    public void dtimetable(View view) {
        Intent i=new Intent(Doctor_mainpage.this,Time_table.class);
        startActivity(i);
    }

    public void dstatus(View view) {
        Intent i=new Intent(Doctor_mainpage.this,op_status.class);
        startActivity(i);
    }

    public void profile(View view) {
    }

    public void fetchdata(View view) {
        Intent i=new Intent(Doctor_mainpage.this,doctorfetchapp.class);
        startActivity(i);

    }

    public void list(View view) {

    }
}

