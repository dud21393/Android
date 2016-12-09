package com.example.jsy.wordapp.m_realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by jsy on 2016-11-09.
 */

public class Category extends RealmObject {

    @PrimaryKey
    private int CategoryId;
    private RealmList<Sentence> Sentences;

    @Required
    private String CategoryName;


    public RealmList<Sentence> getSentences() {
        return Sentences;
    }

    public void setSentences(RealmList<Sentence> sentences) {
        Sentences = sentences;
    }

    public int getCategoryId() {
        return CategoryId;
    }
    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {return CategoryName;}

    public void setCategoryName(String categoryName) { CategoryName = categoryName; }

}
