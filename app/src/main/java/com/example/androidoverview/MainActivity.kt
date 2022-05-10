package com.example.androidoverview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.intentExample.IntentAndFragmentActivity
import kotlinx.android.synthetic.main.activity_main.btnChapterA
import kotlinx.android.synthetic.main.activity_main.btnChapterB
import kotlinx.android.synthetic.main.activity_main.btnChapterD

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}

