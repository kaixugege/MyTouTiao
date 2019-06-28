package com.kaixugege.xu_ec.news_item;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kaixugege.xu.core.lazyload.ILazyLoda;
import com.kaixugege.xu_ec.news.mvp.CategoriesContract;
import com.kaixugege.xu.core.net.entiy.Result;
import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu_ec.R;
import com.kaixugege.xu_ec.news_item.adapter.MyMultAdapter;
import com.kaixugege.xu_ec.news_item.mvp.DiscoveryContract;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
@SuppressLint("ValidFragment")
public class ChannelDelegate extends BaseDelegate implements DiscoveryContract.DiscoveryView {
    private DiscoveryContract.DiscpveryParesent paresent;
    private TextView mCc;
    private String ccTxt;
    private SmartRefreshLayout refreshLayout;
    private RecyclerView recylerview;
    private CategoriesContract.CategoriesPresenter presenter;
    public MyMultAdapter adapter;

    public ChannelDelegate(String cc) {
        this.ccTxt = cc;
    }


    @Override
    public Object getLayout() {
        return R.layout.delegate_channel;
    }

    private boolean isFresh = false;

    @Override
    public void onBindView(View rootView) {

    }

    public void initView(View rootView) {
        mCc = rootView.findViewById(R.id.channel_tx_cc);
        mCc.setText(ccTxt);
//
        refreshLayout = rootView.findViewById(R.id.chnnel_swipeRefreshLayout);
        recylerview = rootView.findViewById(R.id.chnnel_recyclervie);
//
        refreshLayout.setEnableAutoLoadMore(true);
        if (getActivity() != null) {
            refreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
            refreshLayout.setRefreshFooter(new ClassicsFooter(getActivity()));

        }
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                isFresh = true;//设置刷新状态为正在刷新
                initData();
            }
        });
        recylerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //0 表示停止滑动的状态 SCROLL_STATE_IDLE
                //1表示正在滚动，用户手指在屏幕上 SCROLL_STATE_TOUCH_SCROLL
                //2表示正在滑动。用户手指已经离开屏幕 SCROLL_STATE_FLING
                switch (newState) {
                    case 0:
                        if (getActivity() != null)
                            Glide.with(getActivity().getApplicationContext()).pauseRequests();
                        break;
                    case 1:
                        if (getActivity() != null)
                            Glide.with(getActivity().getApplicationContext()).resumeRequests();
                        break;
                    case 2:
                        if (getActivity() != null)
                            Glide.with(getActivity().getApplicationContext()).resumeRequests();
                        break;
                    default:
                        break;
                }
            }
        });
        ArrayList list = new ArrayList<Result.ItemList>();
        recylerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyMultAdapter(new ArrayList<Result.ItemList>(), null);//先给个空的当作默认参数
        recylerview.setAdapter(adapter);


    }

    public void initPresent() {
//        DiscoveryContract discoveryContract = new DiscoveryContract() {
//        };
    }


    private void initData() {
        paresent.discovery();
    }

    @Override
    public ILazyLoda setILoader() {
        return new ILazyLoda() {

            @Override
            public void onFragmentFirstVisible(View rootView) {
                initView(rootView);
                initPresent();
                initData();
            }

            @Override
            public void onFragmentVisibleChange(boolean isVisible) {

            }
        };
    }

    @Override
    public void onDiscoverySuccess(Result result) {
        int start = adapter.getItemCount();
    }

    @Override
    public void onDiscoveryFailed(Throwable error) {

    }
}
