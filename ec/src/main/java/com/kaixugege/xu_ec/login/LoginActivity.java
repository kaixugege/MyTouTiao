package com.kaixugege.xu_ec.login;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.kaixugege.xu_ec.R;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        main = findViewById(R.id.login_delegate_main);
        getSupportFragmentManager().beginTransaction().add(R.id.login_delegate_main, LoginDelegeate.newInstance()).commit();
    }
}
