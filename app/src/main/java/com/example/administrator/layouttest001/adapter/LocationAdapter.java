package com.example.administrator.layouttest001.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.layouttest001.R;
import com.example.administrator.layouttest001.data.LocationHint;
import com.example.administrator.layouttest001.data.OrderDetail;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder>{
    private List<LocationHint> mLocationHintList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View locationView;
        TextView locationName;
        TextView locationAddress;

        public ViewHolder(View view){
            super(view);
            locationView=view;
            locationName=view.findViewById(R.id.location_hint_name);
            locationAddress=view.findViewById(R.id.location_hint_address);
        }
    }

    public LocationAdapter(List<LocationHint> locationHintList){
        mLocationHintList=locationHintList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_location_item,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.locationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                LocationHint locationHint=mLocationHintList.get(position);
                String locationNameBack=locationHint.getLocationName();
                String locationAddressBack=locationHint.getLocationAddress();
                Toast.makeText(v.getContext(),"你点击了:"+position,Toast.LENGTH_LONG);
                EditText editText=v.getRootView().findViewById(R.id.search_edit_text);
                editText.setText(locationNameBack+locationAddressBack);
            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(LocationAdapter.ViewHolder viewHolder, int i) {
        LocationHint locationHint=mLocationHintList.get(i);
        viewHolder.locationName.setText(locationHint.getLocationName());
        viewHolder.locationAddress.setText(locationHint.getLocationAddress());
    }

    @Override
    public int getItemCount() {
        return mLocationHintList.size();
    }
}
