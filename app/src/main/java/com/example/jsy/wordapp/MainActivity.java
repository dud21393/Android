package com.example.jsy.wordapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
    }

    public void mOnClick(View v)
    {
        Intent intent = new Intent(this,Write_Activity.class);
        startActivity(intent);
    }
}
