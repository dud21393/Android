package com.example.jsy.wordapp;

import android.support.v7.app.AppCompatActivity;

import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;

/**
 * Created by jsy on 2017-02-01.
 */

public abstract class WordAbstact extends AppCompatActivity {
    Realm realm;
    RealmHelper rh = new RealmHelper();
}
