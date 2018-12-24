package com.example.administrator.layouttest001;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.example.administrator.layouttest001.adapter.OrderDetailsAdapter;
import com.example.administrator.layouttest001.data.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity   {

    private TextView tt;
    private Button button01;
    private List<OrderDetail> orderDetailList=new ArrayList<>();
    private List<String > text02List=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.huoyun_fragment);
//        setContentView(R.layout.huoyun_search_activity);
//        setContentView(R.layout.activity_confirm_order);
//        setContentView(R.layout.longtextview_test);
//        setContentView(R.layout.activity_payment_success);
//        setContentView(R.layout.activity_recharge_success);
//        button01=findViewById(R.id.button_lijiyongche);
//        button01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("tt1", "tt1");
//                Toast.makeText(getApplicationContext(),"点击用车",Toast.LENGTH_SHORT);
//            }
//        });
        //活动布局显示在状态栏上并使状态栏透明
//        tt=(TextView) findViewById(R.id.tt);
//        tt.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        initText02List();
        initOrderDetails(text02List);
        RecyclerView recyclerView=findViewById(R.id.recyclerview_order_details);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        OrderDetailsAdapter adapter=new OrderDetailsAdapter(orderDetailList);
        recyclerView.setAdapter(adapter);



    }



    private void initText02List(){
        text02List.add("小型面包车");
        text02List.add("2018-11-09 09:50");
        text02List.add("浙江杭州滨江区江南星座1楼");
        text02List.add("浙江杭州江干区伊萨卡国际城");
        text02List.add("赵丽颖");
        text02List.add("15945645645");
        text02List.add("冯绍峰");
        text02List.add("18654578954");
    }

    private void initOrderDetails(List<String > list){
        OrderDetail orderDetai01=new OrderDetail(R.drawable.icon_car_order,"订服务车型:",list.get(0));
        orderDetailList.add(orderDetai01);
        OrderDetail orderDetai02=new OrderDetail(R.drawable.icon_time_order,"用车时间:",list.get(1));
        orderDetailList.add(orderDetai02);
        OrderDetail orderDetai03=new OrderDetail(R.drawable.icon_origin_order,"用车起点:",list.get(2));
        orderDetailList.add(orderDetai03);
        OrderDetail orderDetai04=new OrderDetail(R.drawable.icon_des_order,"用车终点:",list.get(3));
        orderDetailList.add(orderDetai04);
        OrderDetail orderDetai05=new OrderDetail(R.drawable.icon_con_order,"发货联系人:",list.get(4));
        orderDetailList.add(orderDetai05);
        OrderDetail orderDetai06=new OrderDetail(R.drawable.icon_pone_order,"发货联系电话:",list.get(5));
        orderDetailList.add(orderDetai06);
        OrderDetail orderDetai07=new OrderDetail(R.drawable.icon_con_order,"取货联系人:",list.get(6));
        orderDetailList.add(orderDetai07);
        OrderDetail orderDetai08=new OrderDetail(R.drawable.icon_pone_order,"取货联系电话:",list.get(7));
        orderDetailList.add(orderDetai08);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     * @param token
     */
    private void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }



}
