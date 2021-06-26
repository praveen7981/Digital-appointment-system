package com.example.consult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private static int sp=2500;
    TextView textView1,textView2;
    Animation top,bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.img);
        textView1=findViewById(R.id.t1);
        textView2=findViewById(R.id.t2);
        top= AnimationUtils.loadAnimation(this,R.anim.top);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom);
        imageView.setAnimation(top);
        textView1.setAnimation(bottom);
        textView2.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent i=new Intent(MainActivity.this,page2.class);
                startActivity(i);
                finish();
            }
        },sp);
    }
}
