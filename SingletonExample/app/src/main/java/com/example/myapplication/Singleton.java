package com.example.myapplication;

import android.util.Log;

public class Singleton {
    private static Singleton instance;
    private String variable;


    private Singleton() {
        Log.w("MY_TAG", "MySingleton::MySingleton()");
        variable = "My var";
    }

    public static Singleton getInstance(){
        Log.w("MY_TAG", "MySingleton::getInstance()");
        if (null == instance){
            instance = new Singleton();
        }
        return instance;
    }

    public String getVariable() {
        return variable;
    }


    }

