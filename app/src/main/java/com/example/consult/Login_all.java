package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login_all extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_all);
    }

    public void admin(View view) {
        Intent i=new Intent(Login_all.this,Admin.class);
        startActivity(i);
    }

    public void login(View view) {
        Intent i=new Intent(Login_all.this,Login_administration.class);
        startActivity(i);
    }

    public void doctor(View view) {
        Intent i=new Intent(Login_all.this,Login_doctor.class);
        startActivity(i);
    }
}
