package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ConsumeData> consumeDataList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<8;i++){
            ConsumeData consumeData1=new ConsumeData();
            consumeData1.setCreateTime("afallfa");
            consumeData1.setMoney("fadfa");
            consumeData1.setType("afa");
            consumeDataList.add(consumeData1);
        }


        RecyclerView recyclerView=findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager=new CustomManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter consumeAdapter=new RecyclerViewAdapter(consumeDataList);
        recyclerView.setAdapter(consumeAdapter);
    }
}
