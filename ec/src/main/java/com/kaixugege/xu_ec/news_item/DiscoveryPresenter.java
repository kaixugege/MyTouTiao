package com.kaixugege.xu_ec.news_item;

import com.kaixugege.xu_ec.news.mvp.CategoriesContract;
import com.kaixugege.xu_ec.news_item.mvp.DiscoveryContract;
import io.reactivex.disposables.Disposable;

/**
 * @Author: KaixuGege
 * Time:           2019/7/9
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class DiscoveryPresenter implements CategoriesContract.CategoriesPresenter {

    public DiscoveryContract.DiscoveryView discoveryView;

    public DiscoveryPresenter(DiscoveryContract.DiscoveryView discoveryView) {
        this.discoveryView = discoveryView;
    }

    @Override
    public Disposable categories() {
        return null;
    }

    @Override
    public void start() {

    }
}
