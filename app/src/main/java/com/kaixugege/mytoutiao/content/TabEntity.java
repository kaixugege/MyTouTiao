package com.kaixugege.mytoutiao.content;

import com.xugege.xu_lib_tablayout.tablayout.listener.CustomTabEntity;

/**
 * @Author: KaixuGege
 * Time:           2019/5/6
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class TabEntity  implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;

    public TabEntity(String title, int selectedIcon, int unSelectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }
}
