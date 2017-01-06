package com.example.jsy.wordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    ListView lv;

    String[] items;
    int[] categoryIds;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.vocabulary_list);

        realm = Realm.getDefaultInstance();
        result = Rh.vocabularyList(realm);

        vocabularyList();

    }

    public void vocabularyList(){
        int categoryNum = result.size();

        items = new String[categoryNum];
        categoryIds = new int[categoryNum];

        for(int iCount=0; iCount<categoryNum; iCount++)
        {
            items[iCount] = result.get(iCount).getCategoryName();
            categoryIds[iCount] = result.get(iCount).getCategoryId();
        }

        lv = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //WordListClassに移動
                Intent intent = new Intent(getApplicationContext(),WordList.class);
                intent.putExtra("categoryId",categoryIds[position]);
                startActivity(intent);
            }
        }
        );
    }

    //Main画面に戻る時、使う。
    public void backClick(View v){
        Intent mainView = new Intent(this,MainActivity.class);
        startActivity(mainView);
    }


}
