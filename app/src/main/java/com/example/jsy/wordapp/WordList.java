package com.example.jsy.wordapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

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
        categoryId = intent.getIntExtra("categoryId",9999);
        Log.d("category", ""+categoryId);

        ScrollView sv = (ScrollView)findViewById(R.id.scrollView);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        wordList(ll);
        sv.addView(ll);


    }

    //단어 리스트를 불러와서 나열
    //単語リストを呼んできて羅列
    public void wordList(LinearLayout ll){

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        params.topMargin = 10;

        result  = Rh.wordList(realm,categoryId);

        int num = result.get(0).getSentences().size();

        for(int iCount=0; iCount<num; iCount++){
            Button btn = new Button(this);
            btn.setText(result.get(0).getSentences().get(iCount).getKoreanSentence());
            btn.setLayoutParams(params);
            btn.setBackgroundColor(Color.YELLOW);
            btn.setId(result.get(0).getCategoryId());

            /*btn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){

                    //WordListClassに移動
                    Intent intent = new Intent(getApplicationContext(),WordList.class);
                    intent.putExtra("categoryId",v.getId());
                    startActivity(intent);
                    Log.d("Click",""+v.getId());
                }
            });*/

            ll.addView(btn);
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
        Intent mainView = new Intent(this,VocabularyList.class);
        startActivity(mainView);
    }



}
