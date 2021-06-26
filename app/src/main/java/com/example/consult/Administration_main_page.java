package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Administration_main_page extends AppCompatActivity
{
    ImageView img,retrive;
    private static final int PICK_IMAGE=100;
    Uri imageurl;
    Admin_staf factory;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration_main_page);
        img=findViewById(R.id.image);
        retrive=findViewById(R.id.timetable);
        factory=new Admin_staf(this);





        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void upload(View view)
    {
        Intent gallery=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }
    protected void onActivityResult(int requestcode,int resultcode,Intent data)
    {
        super.onActivityResult(requestcode,resultcode,data);
        if(resultcode==RESULT_OK &&requestcode==PICK_IMAGE)
        {
            imageurl=data.getData();
            img.setImageURI(imageurl);

        }
    }

    public void upload_img(View view)
    {
        byte[]bytessp=convertimgtobytearray(img);
        if(factory.save(bytessp))
        {
            Toast.makeText(this, "Save successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "save failed", Toast.LENGTH_SHORT).show();
        }

    }
    private byte[] convertimgtobytearray(ImageView imageView)
    {
        Bitmap bitmap=((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void retive(View view)
    {

        Intent i=new Intent(Administration_main_page.this,Time_table.class);
        startActivity(i);


    }


    public void aprofile(View view) {
    }

    public void astatus(View view) {
        Intent i=new Intent(Administration_main_page.this,op_status.class);
        startActivity(i);
    }

    public void atimetable(View view) {
        Intent i=new Intent(Administration_main_page.this,Time_table.class);
        startActivity(i);
    }

    public void alogout(View view) {
        Intent i=new Intent(Administration_main_page.this,page2.class);
        startActivity(i);
    }

    public void asettings(View view) {
    }
}
