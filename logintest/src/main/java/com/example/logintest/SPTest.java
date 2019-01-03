package com.example.logintest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SPTest extends AppCompatActivity {
    private static final String TAG = "SPTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sptest);
//        spData1();
//        spData2();
        spData3();
    }

    public void spData1(){
        SharedPreferences sharedPreferences=getSharedPreferences("testSP",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("car","Golf");
        boolean b=editor.commit();
    }
    public void spData2(){
        SharedPreferences sharedPreferences=getSharedPreferences("testSP",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("car","tt");
        boolean b=editor.commit();
    }
    public void spData3(){
        SharedPreferences sharedPreferences=getSharedPreferences("testSP",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("car","GLA");
        boolean b=editor.commit();
    }
}
