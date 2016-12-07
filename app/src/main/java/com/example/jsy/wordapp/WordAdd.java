package com.example.jsy.wordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.jsy.wordapp.m_realm.RealmHelper;
import com.example.jsy.wordapp.m_realm.Sentence;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-30.
 */

public class WordAdd extends AppCompatActivity {
    Realm realm;
    RealmHelper Rh = new RealmHelper();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_add);
        realm = Realm.getDefaultInstance();

    }

    //日本語と韓国語の単語を、入力して、SaveするMethod。
    public void wordSaveButton(View v){
        Intent intent = getIntent();
        int categoryId = intent.getIntExtra("categoryId",9999);

        EditText Japanese_Word = (EditText)findViewById(R.id.japaneseWord);
        EditText Korean_word = (EditText)findViewById(R.id.koreanWord);


        Rh.saveWord(realm,Japanese_Word.getText().toString(),Korean_word.getText().toString(),categoryId);

    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent mainView = new Intent(this,MainActivity.class);
        startActivity(mainView);
    }
}