package com.example.smalltestdemo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private ImageView imageView;
    private ImageView imageView2;
    private LinearLayout layout1;
//    private ConstraintLayout layout2;
    private ConstraintLayout.LayoutParams params ;

    private static final String TAG = "MainActivity:dialog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

//        layout2=findViewById(R.id.layout2);
        layout1=findViewById(R.id.layout1);
        params= (ConstraintLayout.LayoutParams) layout1.getLayoutParams();
        System.out.println("测试"+params.height);
        System.out.println("测试"+params.width);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"测试",Toast.LENGTH_LONG);
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("发货人信息");
//                dialog.setIcon(R.drawable.nav_title_background);
                dialog.setView(R.layout.dialog_item01);
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: positive");
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: negative");
                    }
                });
                dialog.show();
            }
        });
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);

        imageView=findViewById(R.id.image1);
        imageView2=findViewById(R.id.image2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了图片",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button1:
                imageView.setVisibility(View.VISIBLE);
                imageView2.setVisibility(View.VISIBLE);
                break;
            case R.id.button2:
                imageView.setVisibility(View.INVISIBLE);
                imageView2.setVisibility(View.INVISIBLE);
                break;
            case R.id.button3:
                imageView.setVisibility(View.GONE);
                imageView2.setVisibility(View.GONE);
                params.height=120;
                layout1.setLayoutParams(params);
                break;

            default:
        }
    }
}
