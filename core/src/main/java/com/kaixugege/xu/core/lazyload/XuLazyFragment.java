package com.kaixugege.xu.core.lazyload;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;


/**
 * @Author: KaixuGege
 * Time:           2019/5/7
 * ProjectName:    XuLazyFragment
 * ClassName:
 * Info:
 */
public abstract class XuLazyFragment extends XuBaseFragment {

    public boolean isStartLazy() {
        return isStartLazy;
    }

    public void setStartLazy(boolean startLazy) {
        isStartLazy = startLazy;
    }

    public boolean isStartLazy = true;//是否开启懒加载，默认开启

    protected boolean isFist = true;//是否第一次登陆，默认第一次进入
    private boolean isReuseView = true;//是否进行复用，默认复用
    private boolean isFragmentVisible; // Fragment是否可见

    private View rootView = null;


    abstract public ILazyLoda setILoader();


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //setUserVisibleHint()有可能在fragment的生命周期外被调用

        if (!isStartLazy()) return;//如果没有开启直接返回

        if (rootView == null) {
            Log.d(TAG, "rootView" + " = null" + "返回");
            return;
        } else {
            Log.d(TAG, "rootView" + " != null");
        }

        if (isFist && isVisibleToUser) {
            Log.d(TAG, "isFist = " + isFist + " isVisibleToUser=" + isVisibleToUser + "  这里是第一次进入了，所以调用onFragment");
            setILoader().onFragmentFirstVisible(rootView); //如果第一次进入并且可见的//回调当前fragment首次可见
            if (setILoader() != null) {
                Log.d(TAG, "开始第一次显示初始化界面");
                setILoader().onFragmentVisibleChange(isVisibleToUser);
            }else{
                Log.d(TAG, "开始第一次显示初始化界面");
            }
            isFist = false;//这里把首次可见给关闭
        } else {
            Log.d(TAG, "isFist = " + isFist + " isVisibleToUser=" + isVisibleToUser);
        }

        //如果只是可见，不是首次可见
        if (isVisibleToUser) {
            isFragmentVisible = true;
            Log.d(TAG, "isVisibleToUser = " + isVisibleToUser + " 这里只是可见 ");
            setILoader().onFragmentVisibleChange(isFragmentVisible);//回调当前fragment可见
            return;
        } else {
            Log.d(TAG, "isVisibleToUser = " + isVisibleToUser);
        }

        if (isFragmentVisible) {
            //如果当前fragment不可见且标识位true
            isFragmentVisible = false;//更改标识
            setILoader().onFragmentVisibleChange(isFragmentVisible);//回调当前fragment不可见
        } else {
            Log.d(TAG, "isFragmentVisible = " + isFragmentVisible);
        }

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(getTag()," -----  执行 onViewCreated");
        //开启了懒加载
        if (isStartLazy()) {

            //如果setUserVisibleHint()在rootView创建前调用时，那么
            //就等到rootView创建完后才回调onFragmentVisibleChange(true)
            //保证onFragmentVisibleChange()的回调发生在rootView创建完成之后，以便支持ui操作
            if (rootView == null) {

                rootView = view;
                //这个函数判断 fragment 是否可见的
                if (getUserVisibleHint()) {
                    if (isFist) {
                        Log.d(TAG, "onViewCreated isFist= " + isFist +" 传入的view="+view+"  rootView="+rootView);
                        if (setILoader() != null) setILoader().onFragmentFirstVisible(rootView);
                        isFist = false;
                    }
//                    setILoader().onFragmentVisibleChange(true);//这个地方不要加,加了会导致fragment还没有创建完成的时候就已经加载懒加载的操作了
                    isFragmentVisible = true;//设置fragment可见
                }
            }
            super.onViewCreated(isReuseView ? rootView : view, savedInstanceState);
        } else {
            //没有开启懒加载
            super.onViewCreated(view, savedInstanceState);
        }


    }

}
