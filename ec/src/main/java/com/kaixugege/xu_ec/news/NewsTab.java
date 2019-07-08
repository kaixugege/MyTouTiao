package com.kaixugege.xu_ec.news;

import java.util.ArrayList;

public class NewsTab {


    public NewsTab setTabs(ArrayList<Tab> tabs) {
        if (tabs == null)
            this.tabs = tabs;
        return this;
    }

    public NewsTab setTabs(Tab tab) {
        if (tabs == null)
            tabs = new ArrayList<Tab>();

        this.tabs.add(tab);
        return this;
    }

    private ArrayList<Tab> tabs;

    public int size() {
        if (tabs == null)
            return 0;
        return tabs.size();
    }

    public class Tab {
        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private Integer num;//第几个
        private String name;//tab的名字

    }
}
