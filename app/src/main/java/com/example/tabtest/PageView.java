package com.example.tabtest;

import android.content.Context;
import android.widget.RelativeLayout;

public abstract class PageView extends RelativeLayout {
    public PageView(Context context) {
        super(context);
    }

    public void updateList() {}
}
