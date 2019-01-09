package com.example.testedittext;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class GetbackPw2Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "GetbackPw2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getback_pw2);
//        TextView textView=findViewById(R.id.textView2);
//        textView.setFocusableInTouchMode(true);
//        ConstraintLayout constraintLayout=findViewById(R.id.cl_parent);
//        constraintLayout.setFocusableInTouchMode(true);
        initEdit();
    }

    public void initEdit(){
        final EditText editText1=findViewById(R.id.editText1);
        final EditText editText2=findViewById(R.id.editText2);
        final EditText editText3=findViewById(R.id.editText3);
        final EditText editText4=findViewById(R.id.editText4);
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editText2.requestFocus();
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editText3.requestFocus();
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                editText4.requestFocus();
            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //这里做网络请求的判断
            }
        });
//        editText1.setFocusableInTouchMode(false);
//        editText2.requestFocus();
//        editText1.clearFocus();

    }

    public void initClick() {
        Button button=findViewById(R.id.button_again);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_again:
                break;

        }
    }



}
