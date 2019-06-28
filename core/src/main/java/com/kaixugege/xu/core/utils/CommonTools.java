package com.kaixugege.xu.core.utils;

import com.kaixugege.xu.core.net.entiy.Result;

import java.util.ArrayList;

/**
 * @Author: KaixuGege
 * Time:           2019/6/28
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public class CommonTools {

    public static int getMultiType(int position, ArrayList<Result.ItemList> datas) {
        String type = datas.get(position).getType();
        return type.hashCode();
    }

}
