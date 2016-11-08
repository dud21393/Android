package com.example.jsy.wordapp.m_realm;

import android.widget.Space;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jsy on 2016-11-08.
 */

public class RealmHelper  {


    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    //WRITE
    public void save(final Spacecraft spacecraft)
    {
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){

                Spacecraft s =realm.copyToRealm(spacecraft);


            }
        });
    }

    //READ/RETIREVE
    public ArrayList<String> retrieve()
    {
        ArrayList<String> spacecrafteNames= new ArrayList<>();
        RealmResults<Spacecraft> spacecrafts = realm.where(Spacecraft.class).findAll();

        for(Spacecraft s: spacecrafts)
        {
            spacecrafteNames.add(s.getName());
        }

        return spacecrafteNames;

    }
}
