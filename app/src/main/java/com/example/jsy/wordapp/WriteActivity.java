package com.example.jsy.wordapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by jsy on 2016-11-08.
 */

public class WriteActivity extends Activity {

    Realm realm;
    RealmHelper Rh = new RealmHelper();

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_main);

        realm = Realm.getDefaultInstance();

    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent main_view = new Intent(this,MainActivity.class);
        startActivity(main_view);
    }



}
