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
public class Product {

    public ArrayList<CustomTabEntity> getmTabEntities() {
        return mTabEntities;
    }

    public void setmTabEntities(ArrayList<CustomTabEntity> mTabEntities) {
        this.mTabEntities = mTabEntities;
    }

    public ArrayList<String> getmTitles() {
        return mTitles;
    }

    public void setmTitles(ArrayList<String> mTitles) {
        this.mTitles = mTitles;
    }

    public ArrayList<Integer> getmIconUnselectIds() {
        return mIconUnselectIds;
    }

    public void setmIconUnselectIds(ArrayList<Integer> mIconUnselectIds) {
        this.mIconUnselectIds = mIconUnselectIds;
    }

    public ArrayList<Integer> getmIconSelectIds() {
        return mIconSelectIds;
    }

    public void setmIconSelectIds(ArrayList<Integer> mIconSelectIds) {
        this.mIconSelectIds = mIconSelectIds;
    }

    public Product(ArrayList<CustomTabEntity> mTabEntities, ArrayList<String> mTitles, ArrayList<Integer> mIconUnselectIds, ArrayList<Integer> mIconSelectIds) {
        this.mTabEntities = mTabEntities;
        this.mTitles = mTitles;
        this.mIconUnselectIds = mIconUnselectIds;
        this.mIconSelectIds = mIconSelectIds;
    }

    private ArrayList<CustomTabEntity> mTabEntities;//tab对象
    private ArrayList<String>  mTitles;//title文字
    private ArrayList<Integer> mIconUnselectIds;//title的icon
    private ArrayList<Integer> mIconSelectIds;//选中之后的icon

}
