package com.example.jsy.wordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

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

//        wordList();

        setContentView(R.layout.word_list);

    }

    //단어 리스트를 불러와서 나열
    //単語リストを呼んできて羅列
    public void wordList(){
        result  = Rh.wordList(realm,categoryId);
        Log.d("SenSize", String.valueOf(result.size()));
        for(int iCount=0; iCount<result.size(); iCount++){

        }
    }

    //+를 눌렀을때 단어추가화면으로 넘어감
    //＋をクリクした時、WordAddに移動
    public void wordAdd(View v){
        Intent intent = new Intent(this,WordAdd.class);
        intent.putExtra("categoryId",categoryId);
        startActivity(intent);
    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent mainView = new Intent(this,MainActivity.class);
        startActivity(mainView);
    }



}
