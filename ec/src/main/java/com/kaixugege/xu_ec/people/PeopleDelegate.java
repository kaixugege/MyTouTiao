package com.kaixugege.xu_ec.people;

import android.os.Bundle;
import android.view.View;

import com.kaixugege.xu_ec.R;
import com.xu.gege.fragment.frg.ILazyLoda;
import com.xu.gege.fragment.frg.XuLazyFragment;

/**
 * @Author: KaixuGege
 * Time:           2019/5/13
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class PeopleDelegate extends XuLazyFragment {

    public static PeopleDelegate newInstance() {
        
        Bundle args = new Bundle();
        
        PeopleDelegate fragment = new PeopleDelegate();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public ILazyLoda setILoader() {
        return new ILazyLoda() {
            @Override
            public void onFragmentFirstVisible() {

            }

            @Override
            public void onFragmentVisibleChange(boolean isVisible) {

            }
        };
    }

    @Override
    public Object getLayout() {
        return R.layout.delegate_people;
    }

    @Override
    public void onBindView(View rootView) {

    }

}
