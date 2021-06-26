package com.example.consult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class Emergency extends AppCompatActivity {
   TextView drivernum,hospinch,doc1,doc2;
    TextView t1;
    Animation blink;
   private static final int REQUEST_CALL=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        drivernum=findViewById(R.id.drviernum);
        hospinch=findViewById(R.id.hos_incha);
        doc1=findViewById(R.id.doc1num);
        doc2=findViewById(R.id.doc2num);
        t1 = findViewById(R.id.blink);
        blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        t1.setAnimation(blink);
    }

    public void hosp_incharge(View view)
    {
        callincharge();
    }

    public void doc2call(View view) {
        calldoc2();
    }

    public void doc1call(View view) {
        calldoc1();
    }

    public void drivercall(View view)
    {
        calldriver();
    }
    private void calldriver()
    {
        String number=drivernum.getText().toString();
        if (number.trim().length()>0)
        {
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else
            {
                String a="tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(a)));

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL)
        {
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                calldriver();
                callincharge();
                calldoc1();
                calldoc2();
            }
            else
            {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void callincharge()
    {
        String number=hospinch.getText().toString();
        if (number.trim().length()>0)
        {
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else
            {
                String a="tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(a)));

            }
        }
    }

    private void calldoc1()
    {
        String number=doc1.getText().toString();
        if (number.trim().length()>0)
        {
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else
            {
                String a="tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(a)));

            }
        }
    }

    private void calldoc2()
    {
        String number=doc2.getText().toString();
        if (number.trim().length()>0)
        {
            if(ContextCompat.checkSelfPermission(Emergency.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Emergency.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else
            {
                String a="tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(a)));

            }
        }
    }



}
