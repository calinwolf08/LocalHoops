package com.example.calin.localhoops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.calin.localhoops.R;

/**
 * Controls login page
 * Splits into Coach, Player, Parent, Other activites accordingly
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
}
