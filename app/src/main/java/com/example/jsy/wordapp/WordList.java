package com.example.jsy.wordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.jsy.wordapp.m_realm.Category;
import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-29.
 */

public class WordList extends AppCompatActivity {
    Realm realm;
    RealmHelper Rh = new RealmHelper();
    private RealmResults<Category> result;
    int categoryId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

        realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        categoryId = intent.getIntExtra("categoryId",999999999);

        if(categoryId != 999999999) {
            wordList();
        }else{

        }
    }

    //단어 리스트를 불러와서 나열
    //単語リストを呼んできて羅列
    public void wordList(){

        result  = Rh.wordList(realm,categoryId);
        int num = result.get(0).getSentences().size();

        ListView listView;
        WordAdapter adapter = new WordAdapter();

        listView = (ListView) findViewById(R.id.wordList);

        for(int iCount=0; iCount<num; iCount++) {
            String japenSentence = result.get(0).getSentences().get(iCount).getJapaneseSentence();
            String koreanSentence = result.get(0).getSentences().get(iCount).getKoreanSentence();
            adapter.addItem(japenSentence,koreanSentence);
        }

        listView.setAdapter(adapter);
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
        Intent vocabularyList = new Intent(this,VocabularyList.class);
        startActivity(vocabularyList);
    }

    //TEST버튼을 눌렀을때 WordTest로 이동
    //テストボタンをクリクした時、WordTestに移動
    public void testClick(View v){
        Intent wordTest = new Intent(this,WordTest.class);
        wordTest.putExtra("categoryId",categoryId);
        startActivity(wordTest);
    }



}
