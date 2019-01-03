package com.example.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;

public class EncryptTest extends AppCompatActivity {
    private static final String TAG = "EncryptTest";
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_test);
        s=new String ("123");
        try {
            encrypt(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        encrypt2("123");
        encrypt2("yourData");
    }

    public void encrypt(String userId) throws UnsupportedEncodingException {
        //加密
        byte[] encode=Base64.encode(userId.getBytes("utf-8"),Base64.DEFAULT);
        String dataKey=new String (encode);
        Log.i(TAG, "encrypt: "+dataKey);

        String dataKey2=Base64.encodeToString(userId.getBytes(),Base64.DEFAULT);
        Log.i(TAG, "encrypt: "+dataKey2);

        //解密
        byte[] decode=Base64.decode(dataKey.getBytes("utf-8"),Base64.DEFAULT);
        String initData=new String (decode,"utf-8");
        Log.i(TAG, "encrypt: "+initData);

        byte[] decode2=Base64.decode(dataKey2.getBytes(),Base64.DEFAULT);
        String initData2=new String (decode2);
        Log.i(TAG, "encrypt: "+initData2);
    }

    public void encrypt2(String userId) {
        //加密
        byte[] encode=Base64.encode(userId.getBytes(),Base64.DEFAULT);
        String dataKey=new String (encode);
        Log.i(TAG, "encrypt: "+dataKey);

        //解密
        byte[] decode=Base64.decode(dataKey.getBytes(),Base64.DEFAULT);
        String initData=new String (decode);
        Log.i(TAG, "encrypt: "+initData);
    }
}
