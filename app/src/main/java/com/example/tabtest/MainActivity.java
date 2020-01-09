package com.example.tabtest;
//ref : https://ironglion.com/archives/android-viewpager-%E5%92%8C-tablayout/
// https://www.ruyut.com/2018/12/android-studio_25.html
//https://givemepass.blogspot.com/2016/07/viewpagertablayouttoolbar.html
//https://juejin.im/post/5a4c2f496fb9a044fd122631#heading-3

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.example.tabtest.PageView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // ViewPager is used to slide the layout horizontally
    private ViewPager viewPager;
    // Used to collect all the layout
    private ArrayList<PageView> pageList;
    // Collect all the title of each layout
    private ArrayList<String> titleName;
    // The tabLayout is the top entry of the interface
    private TabLayout tabs;


    public static PageList1 PageList1_layout;
    public static PageList2 PageList2_layout;
    public static PageList3 PageList3_layout;
    SQLiteDatabase db;
    static  final  String tb_name="test";
    static final String db_name ="testDB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db  = openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);

        String CreateTable = "CREATE TABLE IF NOT EXISTS "+
                tb_name+
                "(_ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR(32)," +
                "price int(32),"+
                "classname int(64) )";
        db.execSQL(CreateTable);

        initSlideLayout();


    }

    private void initSlideLayout() {
        pageList = new ArrayList<>();
        // Create all layout

        pageList.add(new PageList1(MainActivity.this));
        pageList.add(new PageList2(MainActivity.this));
        pageList.add(new PageList3(MainActivity.this));





        // Initialize tabLayout's items
        titleName = new ArrayList<>();
        titleName.add("page 1");
        titleName.add("page 2");
        titleName.add("page 3");

        // Initialize ViewPager
        viewPager = findViewById(R.id.viewPage);
        viewPager.setAdapter(new ViewAdapter(pageList, titleName));
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }







}
