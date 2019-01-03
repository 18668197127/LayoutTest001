package com.example.logintest;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.logintest.retrofitTest.GetCodePost;
import com.example.logintest.retrofitTest.RegisterData;
import com.example.logintest.retrofitTest.SignUpPost;
import com.example.logintest.retrofitTest.TokenVfPost;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String responseString;
    private String responseString2;
    private String responseString3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolClass.i=1;
                TextView textView=findViewById(R.id.text);
                textView.setText("已登录");
                SharedPreferences.Editor editor= (SharedPreferences.Editor) getSharedPreferences("test1",Context.MODE_PRIVATE).edit();
                editor.putString("tt","好车啊");
                boolean b=editor.commit();
                Log.i(TAG, "onClick: "+b);

                //缓存尝试
                File cacheDir = new File(getApplicationContext().getCacheDir(), "test1");
                Log.i(TAG, "onClick: "+cacheDir.getAbsolutePath());
                boolean b2=cacheDir.mkdir();
                Log.i(TAG, "onClick: "+b2);
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(new File(cacheDir, "R8"));
                    String data="超跑";
                    fos.write(data.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitV1();
            }
        });
        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitV2();
            }
        });

        Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitV3();
            }
        });

        SharedPreferences sharedPreferences=getSharedPreferences("test1",Context.MODE_PRIVATE);
        if (sharedPreferences.getString("tt","烂车啊").equals("好车啊")){
            TextView textView=findViewById(R.id.text);
            textView.setText("已登录");
        }

        Log.i(TAG, "onCreate: "+this.getCacheDir().getAbsolutePath());
        Log.i(TAG, "onCreate: "+this.getFilesDir().getAbsolutePath());
        Log.i(TAG, "onCreate: "+this.getExternalCacheDir().getAbsolutePath());
        Log.i(TAG, "onCreate: "+this.getExternalFilesDir(null).getAbsolutePath());
        Log.i(TAG, "onCreate: "+this.getExternalFilesDir(Environment.DIRECTORY_DCIM).getAbsolutePath());


        Log.i(TAG, "onCreate: "+Environment.getDataDirectory().getAbsolutePath());
        Log.i(TAG, "onCreate: "+Environment.getRootDirectory().getAbsolutePath());
        Log.i(TAG, "onCreate: "+Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.i(TAG, "onCreate: "+Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.i(TAG, "onCreate: "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        Log.i(TAG, "onCreate: "+this.getFileStreamPath("custom1").getAbsolutePath());
        Log.i(TAG, "onCreate: "+this.getDir("custom2", Context.MODE_PRIVATE).getAbsolutePath());
        Log.i(TAG, "onCreate: "+this.getObbDir().getAbsolutePath());

    }
    //retrofit获取数据Data2,之后gson解析到Result成员变量中
    public void retrofitV1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://test.mouqukeji.com/api/Login/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                SignUpPost signUpPost=retrofit.create(SignUpPost.class);
//                Call<ResponseBody> call=signUpPost.postData("18668197127","1941","Zsxcfv123456");
                Call<ResponseBody> call=signUpPost.postData2(new RegisterData("18668197127","7678","Zsxcfv123456"));
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            responseString=response.body().string();
                            Log.i(TAG, "onResponse测试: "+responseString);
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
    //retrofit获取数据Data2,之后gson解析到Result成员变量中
    public void retrofitV2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://test.mouqukeji.com/api/Login/")
                        .build();
                GetCodePost getCodePost=retrofit.create(GetCodePost.class);
                Call<ResponseBody> call=getCodePost.postData("18668197127");
//                Call<ResponseBody> call=getCodePost.postData2("18668197127");
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            responseString2=response.body().string();
                            Log.i(TAG, "onResponse测试: "+responseString2);
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
    //retrofit获取数据Data2,之后gson解析到Result成员变量中
    public void retrofitV3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://test.mouqukeji.com/api/Login/")
                        .build();
                 TokenVfPost tokenVfPost =retrofit.create(TokenVfPost.class);
                Call<ResponseBody> call=tokenVfPost.postData("38f9854adf0206a1a5221a767791b707da40d737");
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
