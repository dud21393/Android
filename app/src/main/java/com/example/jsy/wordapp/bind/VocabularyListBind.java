package com.example.jsy.wordapp.bind;

/**
 * Created by jsy on 2017-01-15.
 */

public class VocabularyListBind {
    private String topButton;
    private String emptyText;

    public VocabularyListBind(String topButton, String emptyText) {
        this.topButton = topButton;
        this.emptyText = emptyText;
    }

    public String getTopButton() {
        return this.topButton;
    }

    public String getEmptyText() {
        return this.emptyText;
    }

}
