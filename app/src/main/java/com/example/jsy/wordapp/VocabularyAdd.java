package com.example.jsy.wordapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jsy.wordapp.bind.VocabularyAddBind;
import com.example.jsy.wordapp.databinding.VocabularyAddBinding;
import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by jsy on 2016-11-21.
 */

public class VocabularyAdd extends AppCompatActivity {

    Realm realm;
    RealmHelper rh = new RealmHelper();

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        VocabularyAddBinding binding = DataBindingUtil.setContentView(this,R.layout.vocabulary_add);
        VocabularyAddBind addBind = new VocabularyAddBind("戻る","単語帳・例文帳名","登録");
        binding.setVAdd(addBind);
        
        realm = Realm.getDefaultInstance();
    }

    //단어장저장
    //単語帳save
    public void vocabularySave(View v){
        EditText vbName = (EditText)findViewById(R.id.vocabularyName);
        if(vbName.getText().toString().equals("")){
            Toast.makeText(VocabularyAdd.this,"ちゃんと書いてください。",Toast.LENGTH_SHORT).show();
        }else {
            rh.saveVocabulary(realm, vbName.getText().toString());
            Toast.makeText(VocabularyAdd.this, "Saveしました。", Toast.LENGTH_SHORT).show();
            Intent vocalbularyList = new Intent(this, VocabularyList.class);
            startActivity(vocalbularyList);
        }
    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent mainView = new Intent(this,MainActivity.class);
        startActivity(mainView);
    }


}
