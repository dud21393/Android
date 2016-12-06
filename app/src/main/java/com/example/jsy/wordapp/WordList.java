package com.example.jsy.wordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.jsy.wordapp.m_realm.Category;
import com.example.jsy.wordapp.m_realm.RealmHelper;
import com.example.jsy.wordapp.m_realm.Sentence;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-29.
 */

public class WordList extends AppCompatActivity {
    Realm realm;
    RealmHelper Rh = new RealmHelper();
    private RealmResults<Sentence> result;
    int categoryId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();

        Intent intent = getIntent();

        categoryId = intent.getIntExtra("categoryId",9999);
        Log.d("category", ""+categoryId);

        wordList();

        setContentView(R.layout.word_list);

    }

    public void wordList(){

        result  = Rh.wordList(realm,categoryId);

        for(int iCount=0; iCount<result.size(); iCount++){

        }
    }

    public void wordAdd(){

        Intent intent = new Intent(getApplicationContext(),WordAdd.class);
        intent.putExtra("categoryId",categoryId);
        startActivity(intent);

    }



}
