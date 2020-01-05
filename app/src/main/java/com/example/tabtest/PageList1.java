package com.example.tabtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PageList1 extends PageView{

    public PageList1(Context context) {
        super(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.activity_page_list1, null);
        addView(layout);
    }
}