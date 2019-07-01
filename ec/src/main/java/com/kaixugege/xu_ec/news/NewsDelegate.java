package com.kaixugege.xu_ec.news;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kaixugege.xu.core.lazyload.ILazyLoda;
import com.kaixugege.xu_ec.news.mvp.Categories;
import com.kaixugege.xu_ec.news.mvp.CategoriesContract;
import com.kaixugege.xu.core.rxbus.RxBus;
import com.kaixugege.xu.core.ui.fragments.BaseDelegate;
import com.kaixugege.xu_ec.R;
import com.kaixugege.xu_ec.news.event.ChangeTabEvent;
import com.kaixugege.xu_ec.news.event.RefreshEvent;
import com.xugege.xu_lib_tablayout.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

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
public class NewsDelegate extends BaseDelegate implements CategoriesContract.CategoriesView {
    private CategoriesContract.CategoriesPresenter presenter;

    private String TAG = this.getClass().getSimpleName();
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
    }


    @Override
    public ILazyLoda setILoader() {
        return new ILazyLoda() {

            @Override
            public void onFragmentFirstVisible(View rootView) {
                Log.d(this.getClass().getSimpleName(), "懒加载，第一次显示页面");
                Toast.makeText(getActivity(), "News  第一次显示出来", Toast.LENGTH_LONG).show();
                initPresenter();
                initEvent();
                initView(rootView);
                initData();
            }

            @Override
            public void onFragmentVisibleChange(boolean isVisible) {
                Log.d(this.getClass().getSimpleName(), "懒加载，第一次显示页面");
                Toast.makeText(getActivity(), " News change " + isVisible, Toast.LENGTH_SHORT).show();

            }
        };
    }

    private void initData() {
        if (presenter != null)
            presenter.categories();
    }

    private void initView(View rootView) {
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

    private void initEvent() {
        Log.d(this.getClass().getSimpleName(), " initEvent()");

        RxBus.getInstance().toObservable(RefreshEvent.class).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RefreshEvent>() {
                    @Override
                    public void accept(RefreshEvent refreshEvent) throws Exception {
                        Log.d(TAG, "RefreshEvent  ");
                    }

                });


        RxBus.getInstance().toObservable(ChangeTabEvent.class).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChangeTabEvent>() {
                    @Override
                    public void accept(ChangeTabEvent changeTabEvent) throws Exception {
                        Log.d(TAG, "ChangeTabEvent  ");
                    }
                });
    }

    private void initPresenter() {
        Log.d(this.getClass().getSimpleName(), " initPresenter()");
        presenter = new CategoriesContract.CategoriesPresenter() {
            @Override
            public void start() {

            }

            @Override
            public Disposable categories() {
                return null;
            }
        };
    }

    @Override
    public void onCategoriesSucc(List<Categories> result) {
        Log.d(getClass().getSimpleName(),"onCategoriesSucc");
        ArrayList<Categories> arrayList = (ArrayList<Categories>) result;


    }

    @Override
    public void onCategoriesFail() {
        Log.d(getClass().getSimpleName(),"onCategoriesFail");
    }

    @Override
    public void setPresenter(Object presenter) {
        Log.d(getClass().getSimpleName(),"setPresenter");
        this.presenter = (CategoriesContract.CategoriesPresenter) presenter;
    }
}
