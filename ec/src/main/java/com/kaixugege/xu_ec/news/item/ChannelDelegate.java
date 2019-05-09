package com.kaixugege.xu_ec.news.item;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu_ec.R;
import com.xu.gege.fragment.frg.ILazyLoda;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
@SuppressLint("ValidFragment")
public class ChannelDelegate extends BaseDelegate {

    private TextView mCc;
    private String ccTxt;

    public ChannelDelegate(String cc) {
        this.ccTxt = cc;
    }



    @Override
    public Object getLayout() {
        return R.layout.delegate_channel;
    }

    @Override
    public void onBindView(View rootView) {
        mCc = rootView.findViewById(R.id.channel_tx_cc);
        mCc.setText(ccTxt);
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
}
