package com.kaixugege.xu_ec.news_item.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kaixugege.xu_ec.news_item.entiy.BNews;

/**
 * @Author: KaixuGege
 * Time:           2019/6/28
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class ItemBind {

    public static void bindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

    }

    static void bindMultViewHolder(RecyclerView.ViewHolder viewHolder, int position, BNews.DataItem dataItem) {
        ((ItemTextCardItemHolder)viewHolder).getIvMore().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ((ItemTextCardItemHolder)viewHolder).getIvMoreHeader().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ((ItemTextCardItemHolder)viewHolder).getTvFooter().setText("");
        ((ItemTextCardItemHolder)viewHolder).getTvTite().setText("");
    }

}

