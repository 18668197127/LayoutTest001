package com.example.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

public class CustomManager extends LinearLayoutManager {

    public CustomManager(Context context) {
        super(context);
    }

    public CustomManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int getPaddingLeft() {
        return super.getPaddingLeft();
    }
    @Override
    public int getPaddingRight() {
        return super.getPaddingRight();
    }
}
