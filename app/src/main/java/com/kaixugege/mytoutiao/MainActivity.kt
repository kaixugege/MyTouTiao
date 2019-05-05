package com.kaixugege.mytoutiao

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kaixugege.xu.core.ui.activities.BaseActivity
import com.xugege.xu_lib_tablayout.Test
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun setLayout(): Int = R.layout.activity_main

    override fun onBind() {
        val test: Test = Test()
        test.add(1, 1)
        Toast.makeText(this, test.add(1, 1).toString(), Toast.LENGTH_LONG).show()
        bt_to_main.setOnClickListener(this)
    }

//    override fun setLayout() = R.layout.activity_main

    override fun test() {
    }


    override fun onClick(v: View?) {
        startActivity(Intent(this, ContentActivity::class.java))
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
//
//
//    }

}
