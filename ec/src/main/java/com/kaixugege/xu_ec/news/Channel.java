package com.kaixugege.xu_ec.news;

/**
 * @Author: KaixuGege
 * Time:           2019/4/18
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class Channel {

    public static final int TYPE_MY = 1;
    public static final int TYPE_OTHER = 2;
    public static final int TYPE_MY_CHANNEL = 3;
    public static final int TYPE_OTHER_CHANNEL = 4;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChanglCode() {
        return changlCode;
    }

    public void setChanglCode(String changlCode) {
        this.changlCode = changlCode;
    }

    public int getItemType() {
        return itemType;
    }

    private String title;
    private String changlCode;
    private int itemType;


    public Channel(String title, String changlCode, int itemType) {
        this.title = title;
        this.changlCode = changlCode;
        this.itemType = itemType;
    }

    public Channel(String title, String channelCode) {
        this( title, channelCode,TYPE_MY_CHANNEL);

    }
    public void setItemType(int itemType){
        this.itemType = itemType;
    }

}
