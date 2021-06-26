package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login_administration extends AppCompatActivity {
    EditText username,password;
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_administration);
        username=findViewById(R.id.plusername);
        password=findViewById(R.id.plpassword);
        mydb=new DBHelper(this);

    }

    public void Login(View view)
    {
        String user=username.getText().toString();
        String pass=password.getText().toString();

        if(user.equals("")||pass.equals(""))
        {
            Toast.makeText(this, "Fill all creditials", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Boolean result=mydb.checkusernamepassword(user,pass);
            if(result == true)
            {
                Intent i=new Intent(getApplicationContext(),Administration_main_page.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Inavalid Creditials", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void register(View view) {
        Intent i=new Intent(Login_administration.this,Register_administration.class);
        startActivity(i);
    }
}
