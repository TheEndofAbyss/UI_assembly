package com.example.lenovo.androidtest2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class test2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2xml1);
    }
    public void click(View view){
        AlertDialog alertDialog=new AlertDialog.Builder(this).setView(R.layout.test2xml2).
                setNegativeButton("Cancel", null).
                setPositiveButton("Sign in", null).create();
        alertDialog.show();
    }
}