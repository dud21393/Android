package com.example.jsy.wordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by jsy on 2016-11-21.
 */

public class VocabularyActivity extends AppCompatActivity {

    Realm realm;
    RealmHelper rh = new RealmHelper();

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocabulary);
        realm = Realm.getDefaultInstance();
//        rh.deleteQuery(realm);
    }

    //단어장저장
    //単語帳save
    public void vocabularySave(View v){
        EditText vbName = (EditText)findViewById(R.id.vocabularyName);
        rh.saveVocabulary(realm,vbName.getText().toString());
        Toast.makeText(VocabularyActivity.this, "Saveしました。", Toast.LENGTH_SHORT).show();
        Intent vocalbularyList = new Intent(this,VocabularyList.class);
        startActivity(vocalbularyList);
    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent mainView = new Intent(this,MainActivity.class);
        startActivity(mainView);
    }


}
