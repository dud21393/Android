package com.example.jsy.wordapp.bind;

/**
 * Created by jsy on 2017-01-06.
 */

public class VocabularyAddBind {
    private static String topButton;
    private static String bottomButton;
    private static String textView;

    public VocabularyAddBind(String topButton, String bottomButton, String textView){
        this.topButton = topButton;
        this.bottomButton = bottomButton;
        this.textView = textView;
    }

    public String getTopButton(){
        return this.topButton;
    }
    public String getBottomButton(){
        return this.bottomButton;
    }
    public String getTextView(){
        return this.textView;
    }

}
