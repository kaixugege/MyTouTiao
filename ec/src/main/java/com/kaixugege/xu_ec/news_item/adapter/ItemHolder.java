package com.kaixugege.xu_ec.news_item.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaixugege.xu_ec.R;

/**
 * @Author: KaixuGege
 * Time:           2019/6/28
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class ItemHolder {

    public static RecyclerView.ViewHolder createViewHolder(ViewGroup viewGroup, int ViewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.delegate_channel, viewGroup, false);
        return new ItemTextCardItemHolder(view);
    }

}
