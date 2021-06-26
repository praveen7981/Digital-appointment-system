package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_doctor extends AppCompatActivity {
    EditText username,password;
    EditText docname,docdisg;
    DBHelperdoc db;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_doctor);
        username=findViewById(R.id.dlusername);
        password=findViewById(R.id.dlpassword);
        db=new DBHelperdoc(this);

    
    }

    public void dLogin(View view)
    {
        String user=username.getText().toString();
        String pass=password.getText().toString();

        if(user.equals("")||pass.equals(""))
        {
            Toast.makeText(this, "Fill all creditials", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Boolean login=db.dcheckusernamepassword(user,pass);
            if(login == true)
            {

                Intent i=new Intent(getApplicationContext(),Doctor_mainpage.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Inavalid Creditials", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void dregister(View view)
    {
        Intent i=new Intent(Login_doctor.this,register_doctor.class);
        startActivity(i);
    }
}
