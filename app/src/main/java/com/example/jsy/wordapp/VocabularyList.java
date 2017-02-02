package com.example.jsy.wordapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jsy.wordapp.bind.VocabularyListBind;
import com.example.jsy.wordapp.databinding.VocabularyListBinding;
import com.example.jsy.wordapp.m_realm.Category;
import com.example.jsy.wordapp.recycle.VocabularyRecyclerAdapter;
import com.example.jsy.wordapp.recycle.VocabularyItemList;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-22.
 */

public class VocabularyList extends WordAbstact {
    private RealmResults<Category> result;
    VocabularyListBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.vocabulary_list);
        VocabularyListBind vocabularyListBind = new VocabularyListBind("戻る", "データはありません。");
        binding.setVList(vocabularyListBind);

        realm = Realm.getDefaultInstance();
        result = rh.vocabularyList(realm);

        vocabularyList();
    }

    public void vocabularyList() {
        int count = result.size();

        RecyclerView rv;

        rv = binding.vocabularyLIst;
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setItemAnimator(new DefaultItemAnimator());

        List<VocabularyItemList> list = new ArrayList<VocabularyItemList>();


        for (int iCount = 0; iCount < count; iCount++) {
            VocabularyItemList vocabularyItemList = new VocabularyItemList();

            String categoryName = result.get(iCount).getCategoryName();
            int categoryId = result.get(iCount).getCategoryId();

            vocabularyItemList.setVocalbularyName(categoryName);
            vocabularyItemList.setVocalbularyId(categoryId);
            list.add(vocabularyItemList);
        }
        rv.setAdapter(new VocabularyRecyclerAdapter(list, R.layout.vocabulary_recycler_view));
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    //Main画面に戻る時、使う。
    public void backClick(View v) {
        finish();
    }


}
