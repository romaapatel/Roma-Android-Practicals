package com.example.androidoverview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btnChapterA
import kotlinx.android.synthetic.main.activity_main.btnChapterC
import kotlinx.android.synthetic.main.activity_main.btnChapterB

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnChapterA.setOnClickListener {
            val intent = Intent(this,RegistrationFormActivity::class.java)
            startActivity(intent)
        }
        btnChapterC.setOnClickListener{
            val intent = Intent(this, RecyclerAndListExamplesActivity::class.java)
            startActivity(intent)
        }
        btnChapterB.setOnClickListener{
            val intent = Intent(this,LayoutExampleActivity::class.java)
            startActivity(intent)
        }
    }
}

