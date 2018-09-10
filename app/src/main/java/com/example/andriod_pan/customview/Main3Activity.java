package com.example.andriod_pan.customview;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.coll);
        //设置展示的文字
        collapsingToolbarLayout.setTitle("小姐姐");
        //设置展示文字的颜色
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.bg_blue));
    }
}
