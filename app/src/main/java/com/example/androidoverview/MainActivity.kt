package com.example.androidoverview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.architecture.MVCArchitectureActivity
import com.example.androidoverview.intentExample.IntentAndFragmentActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.btnArchitectureChapter
import kotlinx.android.synthetic.main.activity_main.btnChapterA
import kotlinx.android.synthetic.main.activity_main.btnChapterB
import kotlinx.android.synthetic.main.activity_main.btnChapterD


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "a77f8a2f-5679-4294-9722-c43f00750157",
            Analytics::class.java, Crashes::class.java
        )

        btnChapterA.setOnClickListener {
            val intent = Intent(this@MainActivity, RegistrationFormActivity::class.java)
            startActivity(intent)
        }

        btnChapterD.setOnClickListener {
            val intent = Intent(this@MainActivity, IntentAndFragmentActivity::class.java)
            startActivity(intent)
        }

        btnChapterB.setOnClickListener{
            val intent = Intent(this@MainActivity, LayoutExampleActivity::class.java)
            startActivity(intent)
        }

        btnArchitectureChapter.setOnClickListener {
            val intent = Intent(this@MainActivity, MVCArchitectureActivity::class.java)
            startActivity(intent)
        }
    }
}

