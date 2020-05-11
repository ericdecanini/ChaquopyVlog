package com.ericdecanini.chaquopyvlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        val python = Python.getInstance()
        val pythonFile = python.getModule("helloworldscript")
        val helloWorldString = pythonFile.callAttr("helloworld")
    }
}
