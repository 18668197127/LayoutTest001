package com.example.smalltestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestJsonArray extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_json_array);
        try {
            JSONObject root = new JSONObject();//实例一个JSONObject对象
            root.put("cat", "it");//对其添加一个数据

            JSONArray languages = new JSONArray();//实例一个JSON数组
            JSONObject lan1 = new JSONObject();//实例一个lan1的JSON对象
            lan1.put("id", 1);//对lan1对象添加数据
            lan1.put("ide", "Eclipse");//对lan1对象添加数据
            lan1.put("name", "Java");//对lan1对象添加数据
            JSONObject lan2 = new JSONObject();//实例一个lan2的JSON对象
            lan2.put("id", 2);//对lan2对象添加数据
            lan2.put("ide", "XCode");//对lan2对象添加数据
            lan2.put("name", "Swift");//对lan2对象添加数据
            JSONObject lan3 = new JSONObject();//实例一个lan3的JSON对象
            lan3.put("id", 3);//对lan3对象添加数据
            lan3.put("ide", "Visual Studio");//对lan3对象添加数据
            lan3.put("name", "C#");//对lan3对象添加数据
            languages.put(0, lan1);//将lan1对象添加到JSON数组中去，角标为0
            languages.put(1, lan2);//将lan2对象添加到JSON数组中去，角标为1
            languages.put(2, lan3);//将lan3对象添加到JSON数组中去，角标为2

            root.put("languages", languages);//然后将JSON数组添加到名为root的JSON对象中去
            System.out.println(root);
            System.out.println(languages);
            System.out.println(lan1);
            System.out.println(lan2);
            System.out.println(lan3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
