package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.text.DateFormat;
import java.util.Calendar;

public class Time_table extends AppCompatActivity {

    ImageView img;
    Admin_staf factory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        img=findViewById(R.id.timetable);
        factory=new Admin_staf(this);

    }
    public void view(View view)
    {
        byte[] bytes=factory.get();
        if(bytes !=null)
        {
            Bitmap bitmap=covertToArryToBitmap(bytes);
            img.setImageBitmap(bitmap);

        }
    }
    private Bitmap covertToArryToBitmap(byte[] bytes)
    {
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }
}
