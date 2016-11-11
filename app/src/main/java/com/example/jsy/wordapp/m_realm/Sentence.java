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

    private String KoreanSentence;
    private String JapaneseSentence;

    public int getSentenceId() { return SentenceId;  }

    public void setSentenceId(int sentenceId) {SentenceId = sentenceId; }

    public int getCategoryId() { return CategoryId; }

    public void setCategoryId(int categoryId) { CategoryId = categoryId; }

    public String getKoreanSentence() { return KoreanSentence; }

    public void setKoreanSentence(String koreanSentence) { KoreanSentence = koreanSentence;}

    public String getJapaneseSentence() {return JapaneseSentence;}

    public void setJapaneseSentence(String japaneseSentence) {JapaneseSentence = japaneseSentence;}
}
