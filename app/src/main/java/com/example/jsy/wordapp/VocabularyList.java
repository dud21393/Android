package com.example.jsy.wordapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.jsy.wordapp.m_realm.Category;
import com.example.jsy.wordapp.m_realm.RealmHelper;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-22.
 */

public class VocabularyList extends AppCompatActivity {
    Realm realm;
    RealmHelper Rh = new RealmHelper();
    private RealmResults<Category> result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vocabulary_list);


        realm = Realm.getDefaultInstance();
        result = Rh.vocabularyList(realm);

        ScrollView sv = (ScrollView)findViewById(R.id.scrollView);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        vocabularyView(ll);
        sv.addView(ll);
    }
    public void vocabularyDelete(int categoryId){

    }

    public void vocabularyView(LinearLayout ll)
    {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 10;

        for(int iCount=0; iCount<result.size(); iCount++){
            Button btn = new Button(this);
            btn.setText(result.get(iCount).getCategoryName());
            btn.setLayoutParams(params);
            btn.setBackgroundColor(Color.YELLOW);
            btn.setId(result.get(iCount).getCategoryId());

            btn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){

                    Intent intent = new Intent(getApplicationContext(),WordList.class);
                    intent.putExtra("categoryId",v.getId());
                    startActivity(intent);
                    Log.d("Click",""+v.getId());
                }
            });

            ll.addView(btn);
        }
    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent mainView = new Intent(this,MainActivity.class);
        startActivity(mainView);
    }


}
