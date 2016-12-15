package com.example.jsy.wordapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

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
            LinearLayout ll = (LinearLayout) findViewById(R.id.layoutView);
            wordList(ll);
        }
    }

    //단어 리스트를 불러와서 나열
    //単語リストを呼んできて羅列
    public void wordList(LinearLayout ll){
        result  = Rh.wordList(realm,categoryId);
        int num = result.get(0).getSentences().size();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.bottomMargin = 30;

        for(int iCount=0; iCount<num; iCount++){
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setBackgroundColor(Color.WHITE);
            layout.setLayoutParams(params);


            TextView tv = new TextView(this);
            tv.setText(result.get(0).getSentences().get(iCount).getJapaneseSentence());
            tv.setTextSize(20);
            tv.setGravity(Gravity.LEFT);

            TextView tv2 = new TextView(this);
            tv2.setText(result.get(0).getSentences().get(iCount).getKoreanSentence());
            tv2.setTextSize(20);
            tv2.setGravity(Gravity.RIGHT);

            layout.addView(tv);
            layout.addView(tv2);

            ll.addView(layout);
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
        Intent vocabularyList = new Intent(this,VocabularyList.class);
        startActivity(vocabularyList);
    }

    //TEST버튼을 눌렀을때 WordTest로 이동
    //テストボタンをクリクした時、WordTestに移動
    public void testButton(View v){
        Intent testButton = new Intent(this,WordTest.class);
        testButton.putExtra("categoryId",categoryId);
        startActivity(testButton);
    }



}
