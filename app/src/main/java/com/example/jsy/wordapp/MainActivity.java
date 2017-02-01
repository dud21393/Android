package com.example.jsy.wordapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.jsy.wordapp.bind.MainHandler;
import com.example.jsy.wordapp.bind.MainBind;
import com.example.jsy.wordapp.databinding.MainActivityBinding;

import io.realm.Realm;

public class MainActivity extends WordAbstact {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        MainBind mainBinding = new MainBind("単語帳作る", "単語帳見る");
        MainHandler mainHandler = new MainHandler();

        binding.setMain(mainBinding);
        binding.setHandlers(mainHandler);

        Realm.init(this);

    }

}
