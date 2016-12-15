package com.example.jsy.wordapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jsy on 2016-12-15.
 */

public class listview extends AppCompatActivity {


    ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        lv = (ListView)findViewById(R.id.listView);
        String[] items = {"one","two","three","one","two","three","one","two","three","one","two","three","one","two","three","one","two","three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lv.setAdapter(adapter);
    }
}
