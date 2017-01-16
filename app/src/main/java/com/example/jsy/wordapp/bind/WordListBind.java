package com.example.jsy.wordapp.bind;

/**
 * Created by jsy on 2017-01-15.
 */

public class WordListBind {
    private String topLeftButton;
    private String topRightButton;
    private String topText;
    private String bottomButton;
    private String emptyText;

    public WordListBind(String topLeftButton, String topRightButton, String topText, String bottomButton, String emptyText) {
        this.topLeftButton = topLeftButton;
        this.topRightButton = topRightButton;
        this.topText = topText;
        this.bottomButton = bottomButton;
        this.emptyText = emptyText;
    }

    public String getTopLeftButton() {
        return topLeftButton;
    }

    public String getTopRightButton() {
        return topRightButton;
    }

    public String getTopText() {
        return topText;
    }

    public String getBottomButton() {
        return bottomButton;
    }

    public String getEmptyText() {
        return emptyText;
    }

}
