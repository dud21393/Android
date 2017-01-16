package com.example.jsy.wordapp.m_realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by jsy on 2016-11-09.
 */

public class Sentence extends RealmObject {

    @PrimaryKey
    private int SentenceId;

    @Required
    private String KoreanSentence;
    private String JapaneseSentence;


    public int getSentenceId() {
        return SentenceId;
    }

    public void setSentenceId(int sentenceId) {
        SentenceId = sentenceId;
    }

    public String getKoreanSentence() {
        return KoreanSentence;
    }

    public void setKoreanSentence(String koreanSentence) {
        KoreanSentence = koreanSentence;
    }

    public String getJapaneseSentence() {
        return JapaneseSentence;
    }

    public void setJapaneseSentence(String japaneseSentence) {
        JapaneseSentence = japaneseSentence;
    }


}
