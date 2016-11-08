package com.example.jsy.wordapp.m_realm;

import io.realm.RealmObject;

/**
 * Created by jsy on 2016-11-08.
 */

public class Spacecraft extends RealmObject {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
