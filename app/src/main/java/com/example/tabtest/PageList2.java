package com.example.tabtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class PageList2 extends PageView{

    public PageList2(Context context) {
        super(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.activity_page_list2, null);
        addView(layout);
    }
}