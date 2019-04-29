package com.kaixugege.mytoutiao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.xugege.xu_lib_tablayout.Test
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        startActivity(Intent(this, ContentActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test:Test = Test()
        test.add(1,1)
        Toast.makeText(this,test.add(1,1).toString(),Toast.LENGTH_LONG).show()
        bt_to_main.setOnClickListener(this)
    }
}
