package com.example.jsy.wordapp.m_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jsy on 2016-11-09.
 */

public class Sentence extends RealmObject {

    @PrimaryKey
    private int SentenceId;
    private int CategoryId;

    public String KoreanSentence;
    public String JapaneseSentence;

    public int getSentenceId() {
        return SentenceId;
    }

    public void setSentenceId(int sentenceId) {
        SentenceId = sentenceId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
}
