package com.kaixugege.xu_ec.news_item.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kaixugege.xu.core.net.entiy.Result;
import com.kaixugege.xu_ec.news.NewsTab;
import com.kaixugege.xu_ec.news_item.entiy.BNews;

import java.util.ArrayList;

/**
 * @Author: KaixuGege
 * Time:           2019/6/27
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class MyMultAdapter extends RecyclerView.Adapter {

    private ArrayList<BNews.DataItem> datas;
    private Context mContext;

    public MyMultAdapter(ArrayList<BNews.DataItem> datas, Context mContext) {
        this.datas = datas;
        this.mContext = mContext;
    }


    public void clearAll() {
        if (this.datas != null)
            this.datas.clear();
    }
//
//    public void addAll(ArrayList<Result.ItemList> dataList) {
//        if (this.datas != null) {
//            this.datas.addAll(dataList);
//        }
//    }

    public void addAll(ArrayList<BNews.DataItem> dataItems) {
        if (this.datas != null) {
            this.datas.addAll(dataItems);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        return ItemHolder.createViewHolder(viewGroup, type);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
            ItemBind.bindMultViewHolder(viewHolder,position,datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public enum ITEM_TYPE {
        ITEM_TEXTCARD("textCard"),
        ITEM_BRIEFCARD("briefCard"),
        ITEM_DYNAMIC_INFOCARD("DynamicInfoCard"),
        ITEM_HORICONTAL_SCROLLCARD("horizontalScrollCard"),
        ITEM_FOLLOWCARD("followCard"),
        ITEM_VIDEOSMALLCARD("videoSmallCard"),
        ITEM_SQUARECARD_COLLECTION("squareCardCollection"),
        ITEM_VIDEOCOLLECTION_WITHBRIEF("videoCollectionWithBrief"),
        ITEM_BANNER("banner"),
        ITEM_BANNER2("banner2"),
        ITEM_VIDEO("video"),
        ITEM_VIDEOCOLLECTION_OFHORISCROLLCARD("videoCollectionOfHorizontalScrollCard"),
        ITEM_TEXTHEADER("textHeader"),
        ITEM_TEXTFOOTER("textFooter");

        private String type;
        ITEM_TYPE(String type) {
            this.type = type;
        }
    }


}
