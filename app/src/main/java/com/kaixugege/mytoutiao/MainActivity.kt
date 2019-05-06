package com.kaixugege.mytoutiao

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.widget.Toast
import com.kaixugege.mytoutiao.content.ContentActivity
import com.kaixugege.xu.core.ui.activities.BaseActivity
import com.xugege.xu_lib_tablayout.Test
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {
    val TAG = "MainActivity"

    override fun setLayout(): Int = R.layout.activity_main

    override fun onBind() {
        Log.d(TAG, "obBind")
        val test: Test = Test()
        test.add(1, 1)
        Toast.makeText(this, test.add(1, 1).toString(), Toast.LENGTH_LONG).show()
        bt_to_main.setOnClickListener(this)
        setAnimation()
    }

    private fun setAnimation() {
        val scaleAnimation = ScaleAnimation(
            1.0f,
            1.2f,
            1.0f,
            1.2f,
            ScaleAnimation.RELATIVE_TO_SELF,
            0.5f,
            ScaleAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        scaleAnimation.duration = 2000
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(scaleAnimation)
        animationSet.duration = 2000
        bg_main.startAnimation(animationSet)
        animationSet.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?){
                startActivity(Intent(this@MainActivity, ContentActivity::class.java))
                finish()
            }
            override fun onAnimationStart(animation: Animation?) =Unit

            override fun onAnimationRepeat(animation: Animation?)=Unit

        })
    }

//    override fun setLayout() = R.layout.activity_main

    override fun test() {
    }


    override fun onClick(v: View?) {

    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        Log.d(TAG, "onCreate")
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_main)
//    }

}
