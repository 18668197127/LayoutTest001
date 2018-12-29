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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

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
}
