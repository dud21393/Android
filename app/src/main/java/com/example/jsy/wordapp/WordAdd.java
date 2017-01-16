package com.example.jsy.wordapp;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jsy.wordapp.bind.WordAddBind;
import com.example.jsy.wordapp.databinding.WordAddBinding;
import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by jsy on 2016-11-30.
 */

public class WordAdd extends Activity {
    Realm realm;
    RealmHelper Rh = new RealmHelper();
    WordAddBinding binding;
    int categoryId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.word_add);
        WordAddBind wordAddBind = new WordAddBind("単語帳・例文", "韓国語訳", "戻る", "登録");
        binding.setWAdd(wordAddBind);
        realm = Realm.getDefaultInstance();

    }

    //日本語と韓国語の単語を、入力して、SaveするMethod。
    public void wordSaveButton(View v) {
        Intent intent = getIntent();

        categoryId = intent.getIntExtra("categoryId", 999999999);

        EditText Japanese_Word = binding.japaneseWord;
        EditText Korean_word = binding.koreanWord;

        if (Japanese_Word.getText().toString().equals("") || Korean_word.getText().toString().equals("")) {
            Toast.makeText(WordAdd.this, "ちゃんと書いてください。", Toast.LENGTH_SHORT).show();
        } else {
            if (categoryId != 999999999) {
                Rh.saveWord(realm, Japanese_Word.getText().toString(), Korean_word.getText().toString(), categoryId);
                Toast.makeText(WordAdd.this, "Saveしました。", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, WordList.class);
                intent.putExtra("categoryId", categoryId);
                startActivity(intent);
            } else {
                Toast.makeText(WordAdd.this, "Errorができました。", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, VocabularyList.class);
                startActivity(intent);
            }
        }
    }

    //Main画面に戻る時、使う。
    public void backClick(View v) {
        Intent mainView = new Intent(this, WordList.class);
        mainView.putExtra("categoryId",categoryId);
        startActivity(mainView);
    }
}