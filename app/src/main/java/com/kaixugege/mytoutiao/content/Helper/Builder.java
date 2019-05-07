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
public interface Builder {

    public Builder buildTabs(ArrayList<CustomTabEntity> mTabEntities);

    public Builder buildTitles(ArrayList<String>  mTitles);

    public Builder Icons(ArrayList<Integer> mIconUnselectIds);

    public Builder IconSelect(ArrayList<Integer> mIconSelectIds);


    public Product build();
}