package com.example.administrator.layouttest001;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.example.administrator.layouttest001.adapter.LocationAdapter;
import com.example.administrator.layouttest001.adapter.OrderDetailsAdapter;
import com.example.administrator.layouttest001.data.LocationHint;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";
    //没用到的两个list
//    private List<String> locationAddress=new ArrayList<>();
//    private List<String> locationName=new ArrayList<>();
    private List<LocationHint> locationHintList=new ArrayList<>();
    private EditText searchEditText;
    private LocationAdapter locationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huoyun_search_activity);

        if (Build.VERSION.SDK_INT>=21){
            View decorView=getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

//        InputtipsQuery inputquery = new InputtipsQuery("拱墅区", "杭州");
//        inputquery.setCityLimit(true);//限制在当前城市
//
//        Inputtips inputTips = new Inputtips(SearchActivity.this, inputquery);
//        inputTips.setInputtipsListener(new Inputtips.InputtipsListener() {
//            @Override
//            public void onGetInputtips(List<Tip> list, int i) {
//                for (int y=0;y<list.size();y++){
//                    Log.i(TAG, "onGetInputtips: " + list.get(y).getAdcode() + "," + list.get(y).getAddress() + "," + list.get(y).getDistrict() + "," + list.get(y).getName() + "," + list.get(y).getPoiID() + "," + list.get(y).getTypeCode()
//                        + "," + list.get(y).getPoint());
//                    locationAddress.add(list.get(y).getAddress());
//                    locationName.add(list.get(y).getName());
//                }
//            }
//        });
//        inputTips.requestInputtipsAsyn();

        locationAdapter=new LocationAdapter(locationHintList);
        RecyclerView recyclerView=findViewById(R.id.search_location_recycler);
        LinearLayoutManager manager=new LinearLayoutManager(SearchActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(locationAdapter);

        searchEditText=findViewById(R.id.search_edit_text);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String  content=s.toString().trim();
                InputtipsQuery inputquery = new InputtipsQuery(content, "杭州");
                inputquery.setCityLimit(true);//限制在当前城市
                Inputtips inputTips = new Inputtips(SearchActivity.this, inputquery);
                inputTips.setInputtipsListener(new Inputtips.InputtipsListener() {
                    @Override
                    public void onGetInputtips(List<Tip> list, int i) {

                        if (!locationHintList.isEmpty()){
                            locationHintList.clear();
                        }

                        for (int y=0;y<list.size();y++){
//                            Log.i(TAG, "onGetInputtips: " + list.get(y).getAdcode() + "," + list.get(y).getAddress() + "," + list.get(y).getDistrict() + "," + list.get(y).getName() + "," + list.get(y).getPoiID() + "," + list.get(y).getTypeCode()
//                                    + "," + list.get(y).getPoint());
                            //没用的两个List
//                            locationAddress.add(list.get(y).getAddress());
//                            locationName.add(list.get(y).getName());
                            LocationHint locationHint=new LocationHint(list.get(y).getName(),list.get(y).getAddress());
                            locationHintList.add(locationHint);
                        }
                        locationAdapter.notifyDataSetChanged();
                    }
                });
                inputTips.requestInputtipsAsyn();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
