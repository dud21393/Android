package com.example.jsy.wordapp.bind;

/**
 * Created by jsy on 2017-01-16.
 */

public class WordTestBind {

    private String topButton;
    private String bottomLeftButton;
    private String bottomRightButton;

    public WordTestBind(String topButton, String bottomLeftButton, String bottomRightButton) {
        this.topButton = topButton;
        this.bottomLeftButton = bottomLeftButton;
        this.bottomRightButton = bottomRightButton;
    }

    public String getTopButton() {
        return topButton;
    }

    public String getBottomLeftButton() {
        return bottomLeftButton;
    }

    public String getBottomRightButton() {
        return bottomRightButton;
    }

}
