package com.kaixugege.mytoutiao.content.Helper;

import com.xugege.xu_lib_tablayout.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

/**
 * @Author: KaixuGege
 * Time:           2019/5/6
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class ConcreteBuilder implements Builder {

    private ArrayList<CustomTabEntity> mTabEntities;//tab对象
    private ArrayList<String> mTitles;//title文字
    private ArrayList<Integer> mIconUnselectIds;//title的icon
    private ArrayList<Integer> mIconSelectIds;//选中之后的icon

    ConcreteBuilder() {
    }


    @Override
    public ConcreteBuilder buildTabs(ArrayList<CustomTabEntity> mTabEntities) {
        this.mTabEntities = mTabEntities;
        return this;
    }

    @Override
    public ConcreteBuilder buildTitles(ArrayList<String> mTitles) {
        this.mTitles = mTitles;

        return this;
    }

    @Override
    public ConcreteBuilder Icons(ArrayList<Integer> mIconUnselectIds) {
        this.mIconUnselectIds = mIconUnselectIds;
        return this;
    }

    @Override
    public ConcreteBuilder IconSelect(ArrayList<Integer> mIconSelectIds) {
        this.mIconSelectIds = mIconSelectIds;
        return this;
    }

    @Override
    public Product build() {
        return new Product(this.mTabEntities, this.mTitles, this.mIconUnselectIds, this.mIconSelectIds);
    }
}
