package com.example.jsy.wordapp.m_realm;

/**
 * Created by jsy on 2016-12-30.
 */

public class MyClass {

    public interface MyClassCallbacks {
        public void callbackMethod();
    }

    private MyClassCallbacks myClassCallbacks;

    public void setCallbacks(MyClassCallbacks myClassCallbacks) {
        this.myClassCallbacks = myClassCallbacks;
    }

    public void method() {
        myClassCallbacks.callbackMethod();
    }
}
