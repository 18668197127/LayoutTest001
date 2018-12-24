package com.example.dialogtest01;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;

//这是一个获取屏幕高度的Demo

public class ScreenTest extends AppCompatActivity {
    private static final String TAG = "ScreenTest";
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_test01);
        constraintLayout=findViewById(R.id.screen_test);
        constraintLayout.measure(0,0);
//        Log.i(TAG, "onCreate: "+constraintLayout.getMeasuredHeight()+","+constraintLayout.getMeasuredWidth());
//
//        int screenWidth,screenHeight;
//        WindowManager windowManager = getWindowManager();
//        Display display = windowManager.getDefaultDisplay();
//        screenWidth = display.getWidth();
//        screenHeight = display.getHeight();
//        Log.i(TAG, "onCreate: "+screenWidth+","+screenHeight);
//
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int screenWidth2 = dm.widthPixels;
//        int screenHeight2 = dm.heightPixels;
//        Log.i(TAG, "onCreate: "+screenWidth2+","+screenHeight2);
//
//        Rect frame = new Rect();
//        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
//        int statusBarHeight = frame.top;
//        Log.i(TAG, "onCreate: "+statusBarHeight);
//        Log.i(TAG, "onCreate: "+getStatusBarHeight());
//
//        int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
////statusBarHeight是上面状态栏的高度
//        int titleBarHeight = contentTop - statusBarHeight;
//        Log.i(TAG, "onCreate: "+contentTop+","+titleBarHeight);
//
//        int actionBarHeight = getSupportActionBar().getHeight();
//        Log.i(TAG, "onCreate: "+actionBarHeight);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: "+constraintLayout.getMeasuredHeight()+","+constraintLayout.getMeasuredWidth());

        int screenWidth,screenHeight;
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();
        Log.i(TAG, "onPause: "+screenWidth+","+screenHeight);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth2 = dm.widthPixels;
        int screenHeight2 = dm.heightPixels;
        Log.i(TAG, "onPause: "+screenWidth2+","+screenHeight2);

        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Log.i(TAG, "onPause: "+statusBarHeight);
        Log.i(TAG, "onPause: "+getStatusBarHeight());

        int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
//statusBarHeight是上面状态栏的高度
        int titleBarHeight = contentTop - statusBarHeight;
        Log.i(TAG, "onPause: "+contentTop+","+titleBarHeight);

        int actionBarHeight = getSupportActionBar().getHeight();
        Log.i(TAG, "onPause: "+actionBarHeight);


        int navigationHeight=getNavigationBarHeight(getApplicationContext(),true);
        Log.i(TAG, "onPause: "+navigationHeight);
    }

    //获取状态栏
    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            Log.d(TAG, "get status bar height fail");
            e1.printStackTrace();
            return 75;
        }
    }

    //获取虚拟按键栏高度
    public static int getNavigationBarHeight(Context context, boolean b) {
        int result = 0;
        //是否纯在虚拟按键栏(导航栏)
        if (b) {
            Resources res = context.getResources();
            int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = res.getDimensionPixelSize(resourceId);
            }
        }
        return result;
    }
}
