package com.example.dialogtest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class CustomViewTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_test);
        CustomView01 customView01=findViewById(R.id.custom01);
//        customView01.layout(200,200,0,0);

        Type listType = new TypeToken<List<String>>() {}.getType();

        List<String> target = new LinkedList<String>();

        target.add("first");

        target.add("second");

        target.add("third");

        Gson gson = new Gson();

//生成和解析的时候都要加入Type参数

        String json = gson.toJson(target, listType);

        List<String> target2 = gson.fromJson(json, listType);

        System.out.println("测试:"+json);
        System.out.println("测试:"+target2);
    }
}
