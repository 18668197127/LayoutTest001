package com.example.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.logintest.retrofitTest.SignInPost;
import com.example.logintest.retrofitTest.TokenVfPost;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginHttpTest extends AppCompatActivity {
    private static final String TAG = "LoginHttpTest";

    static String url="http://test.mouqukeji.com/api/Login/Login";
    static String param1="telephone";
    static String param2="password";

    private String responseString4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_http_test);
        Button button=findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitV4("17131454890","yh123456");
            }
        });
        Button button2=findViewById(R.id.button6);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitV4("17131454890","abc123456");
            }
        });
    }


    //登录接口post请求
    public void retrofitV4(final String telephone, final String password) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://test.mouqukeji.com/api/Login/")
                        .build();
                SignInPost signInPost =retrofit.create(SignInPost.class);
                Call<ResponseBody> call=signInPost.postData(telephone,password);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            responseString4=response.body().string();
                            Log.i(TAG, "onResponse测试: "+responseString4);
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
