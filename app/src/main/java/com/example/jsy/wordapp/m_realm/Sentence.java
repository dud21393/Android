package com.example.jsy.wordapp.m_realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jsy on 2016-11-09.
 */

public class Sentence extends RealmObject {

    @PrimaryKey
    private int SentenceId;
    private RealmList<Category> CategoryId;
    private String KoreanSentence;
    private String JapaneseSentence;


    public RealmList<Category> getCategoryId() { return CategoryId; }

    public void setCategoryId(RealmList<Category> categoryId) { CategoryId = categoryId; }

    public int getSentenceId() { return SentenceId;  }

    public void setSentenceId(int sentenceId) {SentenceId = sentenceId; }

    public String getKoreanSentence() { return KoreanSentence; }

    public void setKoreanSentence(String koreanSentence) { KoreanSentence = koreanSentence;}

    public String getJapaneseSentence() {return JapaneseSentence;}

    public void setJapaneseSentence(String japaneseSentence) {JapaneseSentence = japaneseSentence;}
}
