package com.example.jsy.wordapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by jsy on 2016-11-08.
 */

public class Write_Activity extends Activity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_main);
    }
    public void mOnclick(View v)
    {
        finish();
    }
}
