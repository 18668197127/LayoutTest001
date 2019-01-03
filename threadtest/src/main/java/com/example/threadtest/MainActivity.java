package com.example.threadtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String responseString3;
    private String correctTk="38f9854adf0206a1a5221a767791b707da40d737";
    private String errorTk="38f9854adf0206a1a5221a767791b707da40aaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threadTest1();
        retrofitV3(correctTk);
//        retrofitV4(correctTk);
    }

    public void threadTest1(){
        final boolean[] b = {false};
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: 1");
                b[0] =true;
                Log.i(TAG, "run: "+b[0]);
            }
        }).start();
        Log.i(TAG, "threadTest1: "+ b[0]);
        Log.i(TAG, "threadTest1: 2");
    }

    public void retrofitV3(final String token) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://test.mouqukeji.com/api/Login/")
                .build();
        TokenVfPost tokenVfPost =retrofit.create(TokenVfPost.class);
        Call<ResponseBody> call=tokenVfPost.postData(token);
//                Call<ResponseBody> call=getCodePost.postData2("18668197127");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    responseString3=response.body().string();
                    Log.i(TAG, "onResponse测试: "+responseString3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(TAG, "onResponse: "+t.toString());
            }
        });
    }
    public void retrofitV4(final String token) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://test.mouqukeji.com/api/Login/")
                        .build();
                TokenVfPost tokenVfPost =retrofit.create(TokenVfPost.class);
                Call<ResponseBody> call=tokenVfPost.postData(token);
        //                Call<ResponseBody> call=getCodePost.postData2("18668197127");
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            responseString3=response.body().string();
                            Log.i(TAG, "onResponse测试: "+responseString3);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.i(TAG, "onResponse: "+t.toString());
                    }
                });
            }
        }).start();

    }
}
