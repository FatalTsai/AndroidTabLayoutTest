package com.example.tabtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PageList1 extends PageView{

    int page,no;
    String name;
    int classname,price;
    EditText name_edit,price_edit;
    Button Totwo;
    TextView text1;
    Spinner spinner;
    final String[] lunch = {"undefined", "色情片", "避孕用品", "口服避用藥", "性病治療費"};

    static final String db_name ="testDB";
    static  final  String tb_name="test";
    SQLiteDatabase db;
    Button button2;


    public PageList1(Context context) {
        super(context);

        View layout = LayoutInflater.from(context).inflate(R.layout.activity_page_list1, null);
        addView(layout);



        page =1;
        Totwo = findViewById(R.id.two);
        name_edit = findViewById(R.id.name_edit);
        price_edit = findViewById(R.id.price_edit);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sumit","sumit");
                name = name_edit.getText().toString();
                price = Integer.valueOf(price_edit.getText().toString() );
                Log.i("name", name);
                Log.i("price", price+"");
                Log.i("classname", lunch[classname]);

                addData(name,price,classname);
            }
        });




        spinner = (Spinner)findViewById(R.id.spinner);
        /*ArrayAdapter<String> lunchList = new ArrayAdapter<>(PageList1.this,
                android.R.layout.simple_spinner_dropdown_item,
                lunch);*/
        //spinner.setAdapter(lunchList);

        //spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("spinner_item",lunch[position]);
                classname = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }






    private  void  addData(String name ,int price,int  classname)
    {
        ContentValues cv =  new ContentValues(3);
        cv.put("name",name);
        cv.put("price",price);
        cv.put("classname",classname);

        Log.d("name",name);

        db.insert(tb_name,null,cv);

    }


}