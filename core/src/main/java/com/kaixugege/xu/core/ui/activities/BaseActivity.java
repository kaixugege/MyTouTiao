package com.kaixugege.xu.core.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * @Author: KaixuGege
 * Time:           2019/4/30
 * ProjectName:    MyTouTiao
 * ClassName:
 * Info:
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract void test();

    public static final String TAG = "BaseActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Log.d(TAG,"onCreate");
            if (setLayout() == null) {
                System.out.println(" 是 空 类型");
                Toast.makeText(this, "空", Toast.LENGTH_LONG).show();
                throw new ClassCastException(" Xu: setLayout() must not be null !");
            } else if (setLayout() instanceof Integer) {
                System.out.println(" 是 int 类型");
                Toast.makeText(this, "int", Toast.LENGTH_LONG).show();
                setContentView((Integer) setLayout());
                onBind();
            } else if (setLayout() instanceof View) {
                System.out.println(" 是 View 类型");
                Toast.makeText(this, "View", Toast.LENGTH_LONG).show();
                setContentView((View) setLayout());
                onBind();
            } else {
                Toast.makeText(this, "Other", Toast.LENGTH_LONG).show();
                System.out.println(" 是 其他 类型");
                throw new ClassCastException(" Xu: setLayout() must be int or View !");
            }
        }catch (Exception ex){
            Log.d(TAG,""+ex.getMessage());
        }

    }

    public abstract Object setLayout();

    public abstract void onBind();


}
