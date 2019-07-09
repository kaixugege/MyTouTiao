package com.kaixugege.xu_ec.news;

import android.content.Intent;

import java.util.ArrayList;

public class NewsTab {

    public static String[] newsTabs = {"娱乐", "军事", "汽车", "财经", "笑话", "体育", "科技", "感情", "头条"};

    public static int[] newsTabNums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public NewsTab() {

        for (int i = 0; i < newsTabs.length; i++) {
            Tab tab = new Tab(newsTabNums[i], newsTabs[i]);
            tab.setState(false);//默认为不启用
            tab.setPosition(i);
            setTabs(tab);
        }

    }

    public NewsTab changeTabState(int position, boolean state) {
        this.tabs.get(position).setState(state);
        return this;
    }

    public NewsTab setTabs(ArrayList<Tab> tabs) {
        if (tabs == null)
            this.tabs = tabs;
        return this;
    }

    public NewsTab setTabs(Tab tab) {
        if (tabs == null) {
            tabs = new ArrayList<Tab>();
        }
        this.tabs.add(tab);
        return this;
    }

    public ArrayList<Tab> getTabs() {
        return tabs;
    }

    private ArrayList<Tab> tabs;

    public int size() {
        if (tabs == null)
            return 0;
        return tabs.size();
    }

    public static class Tab {
        private Integer position;
        private Integer num;//第几个
        private String title;//tab的名字
        private boolean state;//是否启用

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        public Tab() {

        }

        public Tab(Integer num, String title) {
            this.num = num;
            this.title = title;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public Tab(Integer num) {
            this.num = num;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
}
