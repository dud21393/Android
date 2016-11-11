package com.example.jsy.wordapp.m_realm;

import android.app.Activity;
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

    public void Start_Category(Realm realm,String CategoryName){

        realm.beginTransaction();
        int num = realm.where(Category.class).max("id").intValue() + 1;
        Category category = realm.createObject(Category.class,num);
        category.setCategoryName(CategoryName);
        realm.commitTransaction();
    }
    public void Save_Word(Realm realm,String Japanese_Word,String Korean_Word){

    }

    public void IngQuery(Realm realm){

        RealmResults<Category> ct = realm.where(Category.class).findAll();
        String result =ct.get(0).getCategoryName();
        Log.d("three", String.valueOf(ct.size()));
        Log.d("two",result);

    }


}
