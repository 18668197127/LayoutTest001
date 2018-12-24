package com.example.dialogtest01;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Button buttonUseCar;
    private Button buttonUseCar02;
    private Button buttonUseCar03;
    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.dialog_item01);

        buttonUseCar=findViewById(R.id.button_use_car);
        buttonUseCar.setOnClickListener(this);
        buttonUseCar02=findViewById(R.id.button_use_car02);
        buttonUseCar02.setOnClickListener(this);
        buttonUseCar03=findViewById(R.id.button_use_car03);
        buttonUseCar03.setOnClickListener(this);
        cl=findViewById(R.id.cl);
//        //这是一个Math.round的测试(是否+0.5)
//        Log.i(TAG, "Math.round测试:"+roundtest((float) 11.1,true)+","+roundtest((float) 11.1,false));
//        Log.i(TAG, "Math.round测试:"+roundtest((float) 11.6,true)+","+roundtest((float) 11.6,false));
//        Log.i(TAG, "Math.round测试:"+roundtest((float) 11.0,true)+","+roundtest((float) 11.0,false));
//        Log.i(TAG, "Math.round测试:"+roundtest((float) 11.5,true)+","+roundtest((float) 11.5,false));
    }

    //立即用车按钮为alertdialog,立即用车按钮02为自定义dialog,立即用车按钮03为PopupWindow
    //button_use_car    alertdialog
    //button_use_car2    自定义dialog
    //button_use_car3    popupWindow

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_use_car){

            LayoutInflater inflater = LayoutInflater.from(getApplication());
            View view = inflater.inflate(R.layout.dialog_item01, null);
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("发货人信息");
//                dialog.setIcon(R.drawable.nav_title_background);
            builder.setView(view);
//            dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Log.i(TAG, "onClick: positive");
//                }
//            });
//            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Log.i(TAG, "onClick: negative");
//                }
//            });
            AlertDialog dialog=builder.create();
            Button button=view.findViewById(R.id.button_confirm);
            button.setText("Confirm");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("测试alertdialog内部按钮点击事件");
                }
            });
//            dialog.show();
            //requestWindowFeature(featrueId),它的功能是启用窗体的扩展特性
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            WindowManager.LayoutParams wlp =dialog.getWindow().getAttributes();
            System.out.println(wlp.gravity+"测试");
            wlp.gravity = Gravity.TOP | Gravity.LEFT;
            wlp.x=10;
            wlp.y=10;
            dialog.show();
            dialog.getWindow().setLayout(1040,1200);

//            dialog.getWindow().setLayout(dpToPx(this,316),dpToPx(this,288));

        }
        if (v.getId()==R.id.button_use_car02){
            MyDialog myDialog=new MyDialog(MainActivity.this,R.style.Dialog_Msg);
//            MyDialog myDialog=new MyDialog(MainActivity.this);
            myDialog.setMyOnclickListener("这是外部实现的点击事件", new MyDialog.MyOnclickListener() {
                @Override
                public void onYesClick(String message) {
                    System.out.println("测试:"+message);
                }
            });
            myDialog.show();
        }
        if (v.getId()==R.id.button_use_car03){
            PopupWindow popupWindow = new PopupWindow(this);
            popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setContentView(LayoutInflater.from(this).inflate(R.layout.dialog_item01, null));
            popupWindow.setOutsideTouchable(false);
            popupWindow.setFocusable(false);
            popupWindow.setTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//            popupWindow.showAsDropDown(buttonUseCar);
            popupWindow.showAtLocation(cl,Gravity.TOP | Gravity.LEFT, 0, 100);
        }
    }

    //一个dp根据当前手机dpi转px的方法
    public  static int dpToPx(Context context ,int dp) {
        float density;
        density = context.getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }

    //这是一个Math.round的测试(是否+0.5)
    public  static int roundtest(float f,boolean b) {
        if (b){
            return (int) Math.round((f+0.5));
        }else {
            return Math.round(f);
        }
    }
}
