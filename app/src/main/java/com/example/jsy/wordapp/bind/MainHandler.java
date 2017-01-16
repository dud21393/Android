package com.example.jsy.wordapp.bind;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.jsy.wordapp.VocabularyAdd;
import com.example.jsy.wordapp.VocabularyList;

/**
 * Created by jsy on 2017-01-05.
 */

public class MainHandler extends Activity {
    //단어장저장화면으로이동
    //単語帳のsave画面に移動
    public void vocabularySave(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, VocabularyAdd.class);
        context.startActivity(intent);
    }

    //단어장리스트로 이동
    //単語帳のリストに移動
    public void vocabularyList(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, VocabularyList.class);
        context.startActivity(intent);
    }

}
