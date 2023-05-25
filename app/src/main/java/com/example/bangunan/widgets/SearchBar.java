package com.example.bangunan.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class SearchBar extends LinearLayout {
    public SearchBar(Context context) {
        super(context);
    }

    public SearchBar(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        this.setGravity(Gravity.CENTER);
    }

    public SearchBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SearchBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
