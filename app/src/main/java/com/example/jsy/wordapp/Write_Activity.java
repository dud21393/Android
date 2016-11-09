package com.example.jsy.wordapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by jsy on 2016-11-08.
 */

public class Write_Activity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_main);

    }

    public void Back_click(View v){
        Intent main_view = new Intent(this,MainActivity.class);
        startActivity(main_view);
    }

    public void Save_click(View v){



    }


}
