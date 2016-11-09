package com.example.jsy.wordapp.m_realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jsy on 2016-11-09.
 */

public class Category extends RealmObject {

    @PrimaryKey
    private int CategoryId;

    public String CategoryName;

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
}