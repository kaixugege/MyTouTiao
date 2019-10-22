package com.kaixugege.xu_ec.message;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.kaixugege.xu.core.lazyload.ILazyLoda;
import com.kaixugege.xu.core.lazyload.XuLazyFragment;
import com.kaixugege.xu_ec.R;


/**
 * @Author: KaixuGege
 * Time:           2019/5/13
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class MessageDelegate extends XuLazyFragment {
    public static MessageDelegate newInstance() {
        Bundle args = new Bundle();
        MessageDelegate fragment = new MessageDelegate();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ILazyLoda setILoader() {

        return new ILazyLoda() {

            @Override
            public void onFragmentFirstVisible(View rootView) {
                Toast.makeText(getActivity(), " 消息 第一次显示出来", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFragmentVisibleChange(boolean isVisible) {

            }

        };
    }

    @Override
    public Object getLayout() {
        return R.layout.message_delegate;
    }

    @Override
    public void onBindView(View rootView) {

    }
}
