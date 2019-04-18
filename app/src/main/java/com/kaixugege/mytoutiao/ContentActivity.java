package com.kaixugege.mytoutiao;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaixugege.xu_ec.news.NewsDelegate;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

//        getSupportFragmentManager().beginTransaction().add();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content_ll, new NewsDelegate());// 或者fragmentTransaction.replace(ViewId,fragment);fragmentTransaction.commit();
        fragmentTransaction.commit();
    }

}
