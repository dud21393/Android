package com.example.jsy.wordapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jsy.wordapp.m_realm.Category;
import com.example.jsy.wordapp.m_realm.RealmHelper;

import org.w3c.dom.Text;

import io.realm.Realm;

/**
 * Created by jsy on 2016-11-08.
 */

public class Write_Activity extends AppCompatActivity {

    Realm realm;
    RealmHelper Rh = new RealmHelper();

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_main);

        realm = Realm.getDefaultInstance();

        //もし、CategoryIdが、２より小さいとき使う。
        //CategoryIdを作るため
        if(realm.where(Category.class).max("CategoryId").intValue() < 2)
        {
            //Categoryの、Record追加。
            Start_Category(Rh,realm);
        }

        //Recordが、入っているのかを確認するために使う、method。
        Rh.IngQuery(realm);
    }

    //Main画面に戻る時、使う。
    public void Back_click(View v){
        Intent main_view = new Intent(this,MainActivity.class);
        startActivity(main_view);
    }

    //日本語と韓国語の単語を、入力して、SaveするMethod。
    public void Word_saveButton(View v){

        EditText Japanese_Word = (EditText)findViewById(R.id.Japanese_Word);
        EditText Korean_word = (EditText)findViewById(R.id.Korean_word);

        Rh.Save_Word(realm,Japanese_Word.getText().toString(),Korean_word.getText().toString());

    }

    public void Start_Category(RealmHelper Rh,Realm realm){
        Rh.Start_Category(realm,"単語");
        Rh.Start_Category(realm,"例文");
    }


}
