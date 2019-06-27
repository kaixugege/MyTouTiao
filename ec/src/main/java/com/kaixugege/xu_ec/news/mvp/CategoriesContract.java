package com.kaixugege.xu_ec.news.mvp;


import com.kaixugege.xu.core.mvp.BasePresenter;
import com.kaixugege.xu.core.mvp.BaseView;

import io.reactivex.disposables.Disposable;

import java.util.List;

/**
 * @Author: KaixuGege
 * Time:           2019/6/25
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public interface CategoriesContract {
    interface CategoriesPresenter extends BasePresenter {
        public Disposable categories();
    }

    interface CategoriesView extends BaseView {
        public Disposable onCategoriesSucc( List<Categories> result);
        public Disposable onCategoriesFail();
    }
}
