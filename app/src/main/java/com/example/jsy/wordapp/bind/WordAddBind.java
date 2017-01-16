package com.example.jsy.wordapp.bind;

/**
 * Created by jsy on 2017-01-15.
 */

public class WordAddBind {
    private String japan;
    private String korean;
    private String topButton;
    private String bottomBotton;

    public WordAddBind(String japan, String korean, String topButton, String bottomBotton) {
        this.japan = japan;
        this.korean = korean;
        this.topButton = topButton;
        this.bottomBotton = bottomBotton;
    }

    public String getJapan() {
        return japan;
    }

    public String getKorean() {
        return korean;
    }

    public String getTopButton() {
        return topButton;
    }

    public String getBottomBotton() {
        return bottomBotton;
    }

}
