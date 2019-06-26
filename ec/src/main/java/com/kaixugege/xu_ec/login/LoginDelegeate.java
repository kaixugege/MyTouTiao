package com.kaixugege.xu_ec.login;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.kaixugege.xu.core.app.XuTouTiao;
import com.kaixugege.xu.core.lazyload.XuBaseFragment;
import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu_ec.R;


import java.io.FileInputStream;

/**
 * @Author: KaixuGege
 * Time:           2019/5/20
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class LoginDelegeate extends XuBaseFragment {

    private ProgressBar progressBar;
    private Button login;
    private ImageView back;


    public static LoginDelegeate newInstance() {
        Bundle args = new Bundle();
        LoginDelegeate fragment = new LoginDelegeate();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object getLayout() {
        Log.d(TAG, "getLayout" + R.layout.delegate_login);
        return R.layout.delegate_login;
    }

    @Override
    public void onBindView(View rootView) {
        Log.d(TAG, "onBindView  " + rootView);
        progressBar = rootView.findViewById(R.id.loading);
        back = rootView.findViewById(R.id.login_delegate_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        progressBar.setBackgroundColor(Color.GREEN);
        Log.d(TAG, "onBindView  " + progressBar);

        login = rootView.findViewById(R.id.login_delegate_login);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                XuTouTiao.getConfigurator().withLoginReady(true);
                getActivity().finish();
            }
        });

    }


}
