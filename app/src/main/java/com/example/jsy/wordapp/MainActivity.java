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

    //단어장저장화면으로이동
    //単語帳のsave画面に移動
    public void vocabularyMove(View v)
    {
        Intent intent = new Intent(this,VocabularyActivity.class);
        startActivity(intent);
    }

    //단어장리스트로 이동
    //単語帳のリストに移動
    public void vocabularyList(View v)
    {
        Intent intent = new Intent(this,VocabularyList.class);
        startActivity(intent);
    }

}
