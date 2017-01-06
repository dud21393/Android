package com.example.jsy.wordapp.bind;

public class MainBind {
    private final String vocabularySave;
    private final String vocabularySee;

    public MainBind(String vocabularyMake, String vocabularySee) {
        this.vocabularySave = vocabularyMake;
        this.vocabularySee = vocabularySee;
    }

    public String getVocabularySave() {
        return this.vocabularySave;
    }

    public String getVocabularySee() {
        return this.vocabularySee;
    }
}
