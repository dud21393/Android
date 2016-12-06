package com.example.jsy.wordapp.m_realm;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jsy.wordapp.R;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-10.
 */

public class RealmHelper extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

    }

    public void vocabularySave(Realm realm,String categoryName){

        realm.beginTransaction();
        int num;
        try {
            num = realm.where(Category.class).max("CategoryId").intValue()+1;
        } catch(Exception ex) {
            num = 1;
        }
        Category category = realm.createObject(Category.class,num);
        category.setCategoryName(categoryName);
        realm.commitTransaction();
    }

    public void saveWord(Realm realm,String japaneseWord,String koreanWord){
        realm.beginTransaction();

        realm.commitTransaction();

    }

    public RealmResults<Category> vocabularyList(Realm realm){

        RealmResults<Category> ct = realm.where(Category.class).findAll();

        return ct;

    }

    public void ingQuery(Realm realm){

        RealmResults<Category> ct = realm.where(Category.class).findAll();
        Log.d("num", String.valueOf(ct.size()));

    }

    public void deleteQuery(Realm realm){
        final RealmResults<Category> ct = realm.where(Category.class).findAll();
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                ct.get(0).deleteFromRealm();
            }
        });
    }

    public RealmResults<Sentence> wordList(Realm realm,int categoryId){

        RealmResults<Sentence> st = realm.where(Sentence.class).lessThan("CategoryId", categoryId).findAll();

        return st;

    }




}
