package com.example.consult;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class page2 extends AppCompatActivity {
    DBHelperreview re;

    DBHelperpatient std;
    String c;
    TextView t1;
    private static int y = 1;
    DBHelperupdateapp apps;
    Dbhelperupdate db;
    DBHelperdoctorfetch doctor;
    DBHelperretrive fetch;
    Button b1, b2;
    TextView get, b, next,time1,nexttim;
    Timer timer;
    String app;
    Dialog dialog;
    EditText id, name;
    Spinner problem;
    Animation blink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        get = findViewById(R.id.result);
        doctor = new DBHelperdoctorfetch(this);
        b = findViewById(R.id.get);
        fetch = new DBHelperretrive(this);
        next = findViewById(R.id.inc);
        b2 = findViewById(R.id.visible);
        t1 = findViewById(R.id.blink);
        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        t1.setAnimation(blink);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        problem = findViewById(R.id.problem);
        db = new Dbhelperupdate(this);
        std = new DBHelperpatient(this);

        re=new DBHelperreview(this);

        nexttim = findViewById(R.id.nexttime);

        time1 = findViewById(R.id.time);

        apps = new DBHelperupdateapp(this);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



                String pp = get.getText().toString();
                Integer cc = Integer.parseInt(pp);
                Integer gg = cc + 1;
                String e = String.valueOf(gg);
                if (!pp.isEmpty()) {
                    next.setText(e);
                }
                Calendar calendar=Calendar.getInstance();
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm a");
                String n=time1.getText().toString();
                String time= new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
                String current=time1.getText().toString();
                if(n.isEmpty())
                {
                    nexttim.setText(time);
                }
                else{

                    try {


                        Date date=simpleDateFormat.parse(current);
                        calendar.setTime(date);
                        calendar.add(Calendar.MINUTE,20);
                        String result=simpleDateFormat.format(calendar.getTime());
                        nexttim.setText(result);

                    }
                    catch (Exception d)
                    {
                        time1.setText(current);
                    }

                }


            }

            @Override
            public void afterTextChanged(Editable editable) {



            }
        });

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence p, int i, int i1, int i2) {

                String c=time1.getText().toString();


                if (p.toString().trim().isEmpty()) {
                    b2.setVisibility(View.GONE);
                } else {

                    SQLiteDatabase dbs=getApplicationContext().openOrCreateDatabase("rev.db",Context.MODE_PRIVATE,null);
                    Cursor cr=dbs.rawQuery("select app from revs ORDER BY app desc LIMIT 1",null);
                    StringBuffer result = new StringBuffer();

                    if (cr.getCount() == 0) {
                        get.setText("0");

                    } else {
                        while (cr.moveToNext()) {
                            result.append(cr.getString(0));
                        }
                        get.setText(result);
                    }
                    b2.setVisibility(View.VISIBLE);

                }
                String g=nexttim.getText().toString();
                if(!g.isEmpty())
                {
                    String time= new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
                    SQLiteDatabase dbs=getApplicationContext().openOrCreateDatabase("rev.db",Context.MODE_PRIVATE,null);
                    Cursor br=dbs.rawQuery("select time from revs ORDER BY app desc LIMIT 1",null);
                    StringBuffer result = new StringBuffer();
                    String current;

                    if (br.getCount() == 0) {
                        time1.setText(time);

                    } else {
                        while (br.moveToNext()) {
                            result.append(br.getString(0));
                        }
                        time1.setText(result);
                    }

                }







            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });







    }



    public void Login(View view) {
        Intent i = new Intent(page2.this, Login_all.class);
        startActivity(i);
    }
    public void search (View view)
    {
        Intent i = new Intent(page2.this, searchid.class);
        startActivity(i);

    }
    public void emer (View view)
    {
        Intent em = new Intent(page2.this, emergencypage.class);
        startActivity(em);
    }

    public void home (View view)
    {
        Intent i = new Intent(page2.this, page2.class);
        startActivity(i);
    }

    public void status (View view)
    {
        Intent i = new Intent(page2.this, op_status.class);
        startActivity(i);
    }

    public void timetable (View view)
    {
        Intent i = new Intent(page2.this, Time_table.class);
        startActivity(i);
    }








    public void register(View view) {
        String time= new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
        String s = id.getText().toString();
        String nam = name.getText().toString();
        String prob = problem.getSelectedItem().toString();
         app = next.getText().toString();
        String currentdate = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault()).format(new Date());
        if (s.isEmpty() && nam.isEmpty() && prob.equals("Select your problem")) {
            Toast.makeText(this, "Fill All the Details", Toast.LENGTH_SHORT).show();

        } else if (!s.contains("s") && !s.contains("S")) {
            Toast.makeText(this, "Enter valid  details", Toast.LENGTH_SHORT).show();
        } else {
                   c=nexttim.getText().toString();

                    String mm=String.valueOf(y);


            Boolean resu = re.save(s,nam,prob,currentdate,app,c);

            if (resu == true) {
                dialog = new Dialog(page2.this);
                dialog.setContentView(R.layout.dilog_box);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
                b1 = dialog.findViewById(R.id.op);
                dialog.setTitle("Appoint Number");

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String b=time1.getText().toString();
                        AlertDialog.Builder builder = new AlertDialog.Builder(page2.this);
                        builder.setMessage("Check In Time: " + c);
                        builder.setTitle("Apointment Number: " + app);
                        builder.setCancelable(false);
                        builder.create().show();
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Intent i = new Intent(page2.this, op_status.class);
                                startActivity(i);
                                finish();

                            }
                        }, 5000);

                    }
                });
                dialog.show();

            } else {
                Toast.makeText(this, "appointment not updated", Toast.LENGTH_SHORT).show();
            }

        }
    }
    }







