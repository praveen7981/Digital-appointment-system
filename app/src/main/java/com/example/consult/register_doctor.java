package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register_doctor extends AppCompatActivity {
    EditText fname,lname,usename,password,cpassword,phone;
    DBHelperdoc db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_doctor);
        fname=findViewById(R.id.dfname);
        lname=findViewById(R.id.dlname);
        usename=findViewById(R.id.dusename);
        password=findViewById(R.id.dpassword);
        cpassword=findViewById(R.id.dcpassword);
        phone=findViewById(R.id.dphone);
        db=new DBHelperdoc(this);
    }

    public void docregister(View view)
    {
        String name = fname.getText().toString();
        String namee = lname.getText().toString();
        String user = usename.getText().toString();
        String pass = password.getText().toString();
        String cpass = cpassword.getText().toString();
        String cell=phone.getText().toString();

        if(name.equals("")||namee.equals("")||user.equals("")||pass.equals("")||cpass.equals("")||cell.equals(""))
        {
            Toast.makeText(this, "Fill all The Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(pass.equals(cpass))
            {
                Boolean uresult=db.dcheckusername(user);
                if(uresult == false)
                {
                    Boolean regresult=db.dinsertdata(user,pass,name,namee,cell);
                    if(regresult == true)
                    {
                        Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),Login_doctor.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, "User already Exist", Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(getApplicationContext(),Login_doctor.class);
                    startActivity(i);
                }

            }
            else
            {
                Toast.makeText(this, "Password not Match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
