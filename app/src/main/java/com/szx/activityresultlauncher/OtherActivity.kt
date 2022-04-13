package com.szx.activityresultlauncher

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Author: zzr
 * Date: 2022/4/13
 * Desc:
 */
class OtherActivity : AppCompatActivity() {
    private var extraValue = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvTag).text = "OtherActivity"

        intent.getStringExtra("data").also { extraValue = it.orEmpty() }
        Toast.makeText(this, extraValue, Toast.LENGTH_SHORT).show()

        findViewById<Button>(R.id.btnJump).setOnClickListener {
            setResult(1, Intent().putExtra("result", "other to main"))
            finish()
        }
    }
}