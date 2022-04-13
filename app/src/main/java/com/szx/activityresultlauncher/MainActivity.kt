package com.szx.activityresultlauncher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import com.dylanc.activityresult.launcher.StartActivityLauncher

class MainActivity : AppCompatActivity() {
    private val startActivityLauncher = StartActivityLauncher(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvTag).text = "MainActivity"

        val intent = Intent(this, OtherActivity::class.java)
        intent.putExtra("data", "main to other")

        findViewById<Button>(R.id.btnJump).setOnClickListener {
            startActivityLauncher.launch(intent) { it ->
                if (it.resultCode == 1) {
                    val result = it.data?.getStringExtra("result") ?: ""
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}