package com.example.jsy.wordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by jsy on 2016-11-08.
 */

public class WriteActivity extends AppCompatActivity{

    Realm realm;
    RealmHelper Rh = new RealmHelper();

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_main);

        realm = Realm.getDefaultInstance();

        //もし、CategoryIdが、２より小さいとき使う。
        //CategoryIdを作るため

        //Categoryの、Record追加。
        /*if( realm.where(Category.class).findAll().size() < 2 ){
            Start_Category(Rh,realm);
        }*/

        //Category Delete Query
        Rh.deleteQuery(realm);

        //Recordが、入っているのかを確認するために使う、method。
        //Rh.IngQuery(realm);
    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent main_view = new Intent(this,MainActivity.class);
        startActivity(main_view);
    }

    //日本語と韓国語の単語を、入力して、SaveするMethod。
    public void wordSaveButton(View v){

        EditText Japanese_Word = (EditText)findViewById(R.id.japaneseWord);
        EditText Korean_word = (EditText)findViewById(R.id.koreanWord);

        Rh.saveWord(realm,Japanese_Word.getText().toString(),Korean_word.getText().toString());

    }



}
