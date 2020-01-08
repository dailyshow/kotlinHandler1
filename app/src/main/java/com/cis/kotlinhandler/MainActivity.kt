package com.cis.kotlinhandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var handlerr : Handler? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener { view ->
            var now = System.currentTimeMillis()
            tv1.text = "버튼 클릭 : ${now}"
        }

/*      이렇게 하면 앱이 응답하지 않게 된다. ANR
        while (true) {
            SystemClock.sleep(100)
            var time = System.currentTimeMillis()
            tv2.text = "while : ${time}"
        }*/

        handlerr = Handler()
        var threadd = ThreadClass()
//        handlerr?.post(threadd)
        handlerr?.postDelayed(threadd, 100)
    }

    inner class ThreadClass: Thread() {
        override fun run() {
            var time = System.currentTimeMillis()
            tv2.text = "Handler : ${time}"

//            handlerr?.post(this)
            handlerr?.postDelayed(this, 100)
        }
    }
}
