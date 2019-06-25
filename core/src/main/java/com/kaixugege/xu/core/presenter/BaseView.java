package com.kaixugege.xu.core.presenter;

/**
 * @Author: KaixuGege
 * Time:           2019/6/25
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public interface BaseView<T> {
    // 规定View必须要实现setPresenter方法，则View中保持对Presenter的引用。
    public void setPresenter(T presenter);
}
