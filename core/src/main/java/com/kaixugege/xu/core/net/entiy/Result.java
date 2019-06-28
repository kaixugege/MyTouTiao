package com.kaixugege.xu.core.net.entiy;

import java.util.List;

/**
 * @Author: KaixuGege
 * Time:           2019/6/27
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class Result {

    public List<ItemList> getItemLists() {
        return itemLists;
    }

    public void setItemLists(List<ItemList> itemLists) {
        this.itemLists = itemLists;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public boolean isAdExist() {
        return adExist;
    }

    public void setAdExist(boolean adExist) {
        this.adExist = adExist;
    }

    public Object getUpDateTime() {
        return upDateTime;
    }

    public void setUpDateTime(Object upDateTime) {
        this.upDateTime = upDateTime;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(int refreshCount) {
        this.refreshCount = refreshCount;
    }

    public int getLastStartId() {
        return lastStartId;
    }

    public void setLastStartId(int lastStartId) {
        this.lastStartId = lastStartId;
    }

    private List<ItemList> itemLists;
    private int count = 0;
    private int total = 0;
    private String nextPageUrl;
    private boolean adExist;
    private Object upDateTime;
    private int refreshCount = 0;
    private int lastStartId = 0;


    public class ItemList {
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAdIndex() {
            return adIndex;
        }

        public void setAdIndex(int adIndex) {
            this.adIndex = adIndex;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("ItemList")
                    .append("(")
                    .append(" type=").append(type)
                    .append(" tag=").append(tag)
                    .append(" id=").append(id)
                    .append(" adIndex=").append(adIndex)
                    .append(" data=").append(data)
                    .append(" )");
            return sb.toString();
        }

        private String type;
        private String tag;
        private int id = 0;
        private int adIndex = 0;
        private Object data;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Discovery ")
                .append("(")
                .append(" itemList=").append(itemLists)
                .append(" count=").append(count)
                .append(" total=").append(total)
                .append(" nextPageUrl=").append(nextPageUrl)
                .append(" adExist=").append(adExist)
                .append(" )");
        return sb.toString();
    }

}
