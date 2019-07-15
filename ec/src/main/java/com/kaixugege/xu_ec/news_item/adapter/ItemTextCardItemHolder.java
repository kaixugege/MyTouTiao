package com.kaixugege.xu_ec.news_item.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kaixugege.xu_ec.R;

/**
 * @Author: KaixuGege
 * Time:           2019/7/15
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class ItemTextCardItemHolder  extends RecyclerView.ViewHolder {

    private View rootView;

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public TextView getTvTite() {
        return tvTite;
    }

    public void setTvTite(TextView tvTite) {
        this.tvTite = tvTite;
    }

    public TextView getTvFooter() {
        return tvFooter;
    }

    public void setTvFooter(TextView tvFooter) {
        this.tvFooter = tvFooter;
    }

    public ImageView getIvMoreHeader() {
        return ivMoreHeader;
    }

    public void setIvMoreHeader(ImageView ivMoreHeader) {
        this.ivMoreHeader = ivMoreHeader;
    }

    public ImageView getIvMore() {
        return ivMore;
    }

    public void setIvMore(ImageView ivMore) {
        this.ivMore = ivMore;
    }

    private TextView tvTite;
    private TextView tvFooter;
    private ImageView ivMoreHeader;
    private ImageView ivMore;

    public ItemTextCardItemHolder(@NonNull View itemView) {
        super(itemView);
        rootView = itemView;
        tvTite = itemView.findViewById(R.id.tv_text_card_title);
        tvFooter = itemView.findViewById(R.id.tv_footer);
        ivMoreHeader = itemView.findViewById(R.id.iv_more_header);
        ivMore = itemView.findViewById(R.id.iv_more);
    }
}
