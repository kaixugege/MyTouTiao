package com.kaixugege.xu.core.lazyload;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * @Author: KaixuGege
 * Time:           2019/5/8
 * ProjectName:    XuFragment
 * ClassName:
 * Info:
 */
public abstract class XuBaseFragment extends BaseFragment {

    private View rootView = null;

    public abstract Object getLayout();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {

            if (getLayout() == null) {
                throw new RuntimeException("XU: The setLayout not be null.");
            } else if (getLayout() instanceof Integer) {
                rootView = inflater.inflate((Integer) getLayout(), container, false);
            } else if (getLayout() instanceof View) {
                rootView = (View) getLayout();
            }
            onBindView(rootView);
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    abstract public void onBindView(View rootView);

//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Log.d(TAG, "onAttach");
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.d(TAG, "onPause");
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.d(TAG, "onStart");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG, "onDestroy");
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        Log.d(TAG, "onDestroyView");
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.d(TAG, "onResume");
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.d(TAG, "onStop");
//    }

}
