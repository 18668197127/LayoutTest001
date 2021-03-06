package com.example.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "ConsumeAdapter";

    private List<ConsumeData> mConsumeDataList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View view){
            super(view);
            textView1=view.findViewById(R.id.textview_consume_type);
            textView2=view.findViewById(R.id.textview_consume_time);
            textView3=view.findViewById(R.id.textview_consume_price);
        }
    }
    public RecyclerViewAdapter(List<ConsumeData> consumeDataList){
        mConsumeDataList = consumeDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_consumelist,viewGroup,false);
        RecyclerViewAdapter.ViewHolder holder=new RecyclerViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ConsumeData consumeData=mConsumeDataList.get(i);
        viewHolder.textView2.setText(consumeData.getCreateTime());
        viewHolder.textView3.setText("-"+consumeData.getMoney());
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount: "+mConsumeDataList.size());
        return mConsumeDataList.size();
    }
}
