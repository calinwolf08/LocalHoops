package com.example.calin.localhoops.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.calin.localhoops.R;
import com.example.calin.localhoops.User;

/**
 * Controls login page
 * Splits into Coach, Player, Parent, Other activites accordingly
 */
public class LoginActivity extends AppCompatActivity {
    EditText emailTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailTextField = (EditText) findViewById(R.id.emailTextField);
    }

    public void login(View view) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        String email = emailTextField.getText().toString();

        //login correct
        switch (email) {
            case "admin":
                intent.putExtra("userType", User.ADMIN);
                break;
            case "coach":
                intent.putExtra("userType", User.COACH);
                break;
            case "parent":
                intent.putExtra("userType", User.PARENT);
                break;
            case "player":
                intent.putExtra("userType", User.PLAYER);
                break;
            default:
                intent.putExtra("userType", User.ADMIN);

        }



        startActivity(intent);
    }
}
