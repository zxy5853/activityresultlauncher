package com.szx.activityresultlauncher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dylanc.activityresult.launcher.StartActivityLauncher

class MainActivity : AppCompatActivity() {
    private val startActivityLauncher = StartActivityLauncher(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivityLauncher.launch(intent) { it ->
            if (it.resultCode == 1) {
                val result = it.data?.getBooleanExtra("result", false)?:false
                if (result) {

                }
            }
        }
    }
}