package com.example.jsy.wordapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jsy.wordapp.m_realm.Category;
import com.example.jsy.wordapp.m_realm.RealmHelper;

import java.util.Vector;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-12-15.
 */

public class WordTest extends Activity {
    Realm realm;
    RealmHelper rh = new RealmHelper();
    int categoryId;
    private RealmResults<Category> result;
    int count;
    ViewPager pager;
    Vector<String> vector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        categoryId = intent.getIntExtra("categoryId", 999999999);

        setContentView(R.layout.word_test);

        test();
    }

    //Test List作る。
    public void test() {
        result = rh.wordList(realm, categoryId);
        int num = result.get(0).getSentences().size();
        count = 0;

        //Vectorを利用して、配列を作る。
        vector = new Vector<String>();

        for (int iCount = 0; iCount < num; iCount++) {
            vector.addElement(result.get(0).getSentences().get(iCount).getJapaneseSentence());
            vector.addElement(result.get(0).getSentences().get(iCount).getKoreanSentence());
        }

        final TextView text = (TextView) findViewById(R.id.textView);
        Button prev = (Button) findViewById(R.id.preClick);
        Button next = (Button) findViewById(R.id.nextClick);
        text.setText(vector.get(count));

        prev.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                count--;
                text.setText(vector.get(count));
            }
        });

        next.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                count++;
                text.setText(vector.get(count));
            }
        });


    }
}
