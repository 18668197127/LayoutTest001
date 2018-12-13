package com.example.administrator.layouttest001.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.layouttest001.R;


public class HuoyunFragment extends Fragment {

    private TabLayout tabLayout1;
    private Button buttonYongche;
    private Button buttonYuyue;
    private String [] carString=new String []{"小型面包车","中型面包车","小型货车","中型货车"};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.huoyun_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTab1();
        buttonYongche=getActivity().findViewById(R.id.button_lijiyongche);
        buttonYuyue=getActivity().findViewById(R.id.button_yuyue);
        buttonYongche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ff1", "ff1");
                Toast.makeText(getContext(),"点击用车",Toast.LENGTH_SHORT);
            }
        });
        buttonYuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ff2", "onClick: ff2");
            }
        });
    }

    private void setTab1(){
        tabLayout1=getView().findViewById(R.id.huoyun_tablayout);
        for (int i=0;i<carString.length;i++){
            tabLayout1.addTab(tabLayout1.newTab());
        }
        for (int i=0;i<carString.length;i++){
            tabLayout1.getTabAt(i).setText(carString[i]);
        }
    }


}
