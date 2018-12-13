package com.example.smalltestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Test01 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);

        //相对布局的加载视图测试
        RelativeLayout rl=findViewById(R.id.rl);
        LayoutInflater layoutInflater=LayoutInflater.from(this);

        View view1=layoutInflater.inflate(R.layout.activity_test01_item01,rl,false);
//        View view=layoutInflater.inflate(R.layout.activity_test01_item01,null,true);
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) view1.getLayoutParams();
//        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.leftMargin = 600;
        rl.addView(view1,params1);
        View view2=layoutInflater.inflate(R.layout.activity_test01_item02,null,false);
        rl.addView(view2);


//        //线性布局的加载视图测试
//        setContentView(R.layout.activity_test02);
//        LinearLayout ll=findViewById(R.id.ll);
//        LayoutInflater layoutInflater2=LayoutInflater.from(this);
//        View view3=layoutInflater2.inflate(R.layout.activity_test01_item01,ll,false);
////        View view=layoutInflater.inflate(R.layout.activity_test01_item01,null,true);
//        ll.addView(view3,-1);
//        View view4=layoutInflater2.inflate(R.layout.activity_test01_item02,ll,false);
//        ll.addView(view4,0);

//        //另一种view加载尝试,直接报错java.lang.IllegalArgumentException: Cannot add a null child view to a ViewGroup
//        LinearLayout rl_item =findViewById(R.id.ll_item01);
//        rl.addView(rl_item);

        //两个动态加载的添加点击事件试试
        Button button1=findViewById(R.id.button1_item01);
        Button button2=findViewById(R.id.button2_item02);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("test:你好button1");
            }
        });
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("test", "你好button2");
    }
}
