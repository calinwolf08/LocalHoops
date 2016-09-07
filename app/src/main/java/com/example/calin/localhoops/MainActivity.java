package com.example.calin.localhoops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Controls login page
 * Splits into Coach, Player, Parent, Other activites accordingly
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
