package com.example.andriod_pan.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<String> list=new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for (int i = 0; i <16 ; i++) {
            list.add("pan"+"+++"+i);
        }

        recyclerView = findViewById(R.id.rv_pan);
        final GridLayoutManager manager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter(this, list);
        recyclerView.setAdapter(adapter);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isFoot(position) || adapter.isHead(position) ? manager.getSpanCount() : 1;
            }
        });

    }
}
