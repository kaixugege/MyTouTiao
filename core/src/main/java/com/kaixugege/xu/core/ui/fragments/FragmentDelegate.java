package com.kaixugege.xu.core.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public abstract class FragmentDelegate extends Fragment {

    abstract public Object setLayout();

    public View getRootView() {
        return rootView;
    }

    private View rootView = null;

    abstract public Object onBindView(View rootView);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (setLayout() == null) {
            throw new ClassCastException(" setLayout() type couldn't to be null ");
        } else if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) rootView;
        }

        onBindView(rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.rootView = null;

    }
}
