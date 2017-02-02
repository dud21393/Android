package com.example.jsy.wordapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jsy.wordapp.bind.WordTestBind;
import com.example.jsy.wordapp.databinding.WordTestBinding;
import com.example.jsy.wordapp.m_realm.Category;

import java.util.Vector;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-12-15.
 */

public class WordTest extends WordAbstact {
    int categoryId;
    private RealmResults<Category> result;
    int count;
    Vector<String> vector;
    WordTestBinding binding;
    TextView text;
    int num;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        categoryId = intent.getIntExtra("categoryId", 999999999);

        binding = DataBindingUtil.setContentView(this,R.layout.word_test);
        WordTestBind wordTestBind = new WordTestBind("戻る","PREV","NEXT");
        binding.setWTest(wordTestBind);

        test();
    }

    //Test List作る。
    public void test() {
        result = rh.wordList(realm, categoryId);
        num = result.get(0).getSentences().size();
        count = 0;

        //Vectorを利用して、配列を作る。
        vector = new Vector<String>();

        for (int iCount = 0; iCount < num; iCount++) {
            vector.addElement(result.get(0).getSentences().get(iCount).getJapaneseSentence());
            vector.addElement(result.get(0).getSentences().get(iCount).getKoreanSentence());
        }

        text = binding.textView;
        Button prev = binding.preClick;
        Button next = binding.nextClick;
        text.setText(vector.get(count));

        prev.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(count > 0){
                    count--;
                    text.setText(vector.get(count));
                }else{
                    Toast.makeText(WordTest.this, "最初の単語です。", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if(count <= num){
                    count++;
                    text.setText(vector.get(count));
                }else{
                    Toast.makeText(WordTest.this, "最後の単語です。", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void backClick(View v){
        finish();
    }
}
