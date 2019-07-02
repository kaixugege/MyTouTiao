package com.kaixugege.xu_ec.news.mvp;

import io.reactivex.disposables.Disposable;

/**
 * @Author: KaixuGege
 * Time:           2019/7/2
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class CategoriesPresenter implements CategoriesContract.CategoriesPresenter {
    private Disposable disposable;

    public CategoriesPresenter(CategoriesContract.CategoriesView categoriesView) {
        this.categoriesView = categoriesView;
    }

    private CategoriesContract.CategoriesView categoriesView;


    @Override
    public Disposable categories() {
        return disposable;
    }

    @Override
    public void start() {

    }
}
