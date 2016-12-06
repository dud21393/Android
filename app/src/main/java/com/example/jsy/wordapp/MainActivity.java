package com.example.jsy.wordapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Realm.init(this);
    }

    public void vocabularySave(View v)
    {
        Intent intent = new Intent(this,VocabularyActivity.class);
        startActivity(intent);
    }

    public void vocabularyList(View v)
    {
        Intent intent = new Intent(this,VocabularyList.class);
        startActivity(intent);
    }

}
