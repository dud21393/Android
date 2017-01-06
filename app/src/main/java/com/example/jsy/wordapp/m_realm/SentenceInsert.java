package com.example.jsy.wordapp.m_realm;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by jsy on 2017-01-02.
 */

public class SentenceInsert extends Activity implements MyClass.MyClassCallbacks {

    public void foo() {
        MyClass myClass = new MyClass();
        myClass.setCallbacks(this);
        myClass.method();
    }

    public void callbackMethod() {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
    }
}
