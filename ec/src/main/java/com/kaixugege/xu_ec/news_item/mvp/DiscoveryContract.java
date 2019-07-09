package com.kaixugege.xu_ec.news_item.mvp;

import com.kaixugege.xu.core.net.entiy.Result;

import com.kaixugege.xu_ec.news_item.entiy.BNews;
import io.reactivex.disposables.Disposable;

/**
 * @Author: KaixuGege
 * Time:           2019/6/27
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public interface DiscoveryContract {

    public interface DiscpveryParesent{
        public Disposable discovery();
    }

    public interface DiscoveryView{
        void onDiscoverySuccess(BNews bNews);
        void onDiscoveryFailed(Throwable error);
    }

}
