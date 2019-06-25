package com.kaixugege.xu_ec.news;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kaixugege.xu.core.mvp.CategoriesContract;
import com.kaixugege.xu.core.rxbus.RxBus;
import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu_ec.R;
import com.kaixugege.xu_ec.news.event.ChangeTabEvent;
import com.kaixugege.xu_ec.news.event.RefreshEvent;
import com.xu.gege.fragment.frg.ILazyLoda;
import com.xugege.xu_lib_tablayout.tablayout.SlidingTabLayout;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class NewsDelegate extends BaseDelegate {
    private CategoriesContract.CategoriesPresenter presenter;

    private String TAG = "NewsDelegate";
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    ViewPager viewPager;
    VpAdapter vpAdapter;
    SlidingTabLayout tab;
    ImageView search;
    ImageView add;

    public static NewsDelegate newInstance(String s) {

        Bundle args = new Bundle();

        NewsDelegate fragment = new NewsDelegate();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Object getLayout() {
        Log.d("NewsDelegate", "开始getlayout");
        return R.layout.delegate_news;
    }

    @Override
    public void onBindView(View rootView) {
        Log.d("NewsDelegate", "onBindView");

        viewPager = ViewFindUtils.find(rootView, R.id.news_vp);
        tab = ViewFindUtils.find(rootView, R.id.content_tablayout);
        search = ViewFindUtils.find(rootView, R.id.iv_search);
        add = ViewFindUtils.find(rootView, R.id.iv_add);

        vpAdapter = new VpAdapter(getFragmentManager(), Helper.initChannelData(), Helper.initFragmentData());
        viewPager.setAdapter(vpAdapter);


        tab.setViewPager(viewPager, Helper.getData(), getActivity(), Helper.initFragmentData());
        tab.setTabPadding(12);
        tab.setTabSpaceEqual(true);
        tab.setTextSelectColor(getActivity().getResources().getColor(R.color.black));
        tab.setTextUnselectColor(getActivity().getResources().getColor(R.color.textbg));
    }


    @Override
    public ILazyLoda setILoader() {
        return new ILazyLoda() {
            @Override
            public void onFragmentFirstVisible() {
                Toast.makeText(getActivity(), "fragment第一次显示出来", Toast.LENGTH_SHORT).show();
                initPresenter();
                initEvent();
            }

            @Override
            public void onFragmentVisibleChange(boolean isVisible) {
                Toast.makeText(getActivity(), " fragment change " + isVisible, Toast.LENGTH_SHORT).show();

            }
        };
    }

    private void initEvent() {
        RxBus.getInstance().toObservable(RefreshEvent.class).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RefreshEvent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RefreshEvent refreshEvent) {
                        Toast.makeText(getActivity(), "refresh", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        RxBus.getInstance().toObservable(ChangeTabEvent.class).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChangeTabEvent>() {
                    @Override
                    public void accept(ChangeTabEvent changeTabEvent) throws Exception {

                    }
                });
    }

    private void initPresenter() {
//        CategoriesContract.CategoriesPresenter c =new CategoriesContract.CategoriesPresenter(this);
    }
}
