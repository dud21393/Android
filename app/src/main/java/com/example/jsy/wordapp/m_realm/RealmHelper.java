package com.example.jsy.wordapp.m_realm;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-10.
 */

public class RealmHelper {

    public void saveVocabulary(Realm realm,String categoryName){

        realm.beginTransaction();
        int categoryId;
        try {
            categoryId = realm.where(Category.class).max("CategoryId").intValue()+1;
        } catch(Exception ex) {
            categoryId = 1;
        }
        Category category = realm.createObject(Category.class,categoryId);
        category.setCategoryName(categoryName);
        realm.commitTransaction();
    }

    public void saveWord(Realm realm,  String japaneseWord,  String koreanWord,  int categoryId){

        realm.beginTransaction();
        int sentenceId;
        try {
            sentenceId = realm.where(Sentence.class).max("SentenceId").intValue()+1;
        } catch(Exception ex) {
            sentenceId = 1;
        }

        Log.d("sentenceId", String.valueOf(sentenceId));

        Category category = realm.where(Category.class).equalTo("CategoryId",categoryId).findFirst();

        Log.d("cc",String.valueOf(category.getCategoryId()));


        Sentence sentence = realm.createObject(Sentence.class,sentenceId);
        sentence.setKoreanSentence(koreanWord);
        sentence.setJapaneseSentence(japaneseWord);
        category.getSentences().add(sentence);

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
        final RealmResults<Sentence> st = realm.where(Sentence.class).findAll();
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                st.get(0).deleteFromRealm();
            }
        });
    }

    public RealmResults<Category> wordList(Realm realm,int categoryId){
        
        RealmResults<Category> ct = realm.where(Category.class)
                .equalTo("CategoryId",categoryId)
                .findAll();

        return ct;

    }

}
