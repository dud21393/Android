package com.example.jsy.wordapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by jsy on 2016-12-15.
 */

public class WordTest extends AppCompatActivity {
    Realm realm;
    RealmHelper rh = new RealmHelper();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_test);

    }
}
