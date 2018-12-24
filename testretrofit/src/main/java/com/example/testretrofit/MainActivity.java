package com.example.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.testretrofit.gsonData1.Result;
import com.example.testretrofit.retrofit.ZhailuData1;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "onResponse: 测试");
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://test.mouqukeji.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ZhailuData1 zhailuData1=retrofit.create(ZhailuData1.class);
                Call<Result> call=zhailuData1.getZhailuData();
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        Log.i(TAG, "onResponse: 测试");
                        Result result=response.body();
                        Log.i(TAG, "onResponse: 测试");
                        for (int i=0;i<4;i++){
                            Log.i(TAG, "onResponse: 测试");
                            Log.i(TAG, "onResponse测试: "+result.getData().getCategories().get(0).getId());
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        Log.i(TAG, "onResponse: 测试");
                    }
                });
            }
        }).start();
    }
}

