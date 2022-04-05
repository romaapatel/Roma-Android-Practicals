package com.example.androidoverview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recycler_and_list_examples.btnList
import kotlinx.android.synthetic.main.activity_recycler_and_list_examples.btnRecycler
import kotlinx.android.synthetic.main.activity_recycler_and_list_examples.btnWhatsapp

class RecyclerAndListExamplesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_and_list_examples)

        btnRecycler.setOnClickListener {
            val intent = Intent(this,RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btnList.setOnClickListener{
            val intent = Intent(this, ListExampleActivity::class.java)
            startActivity(intent)
        }
        btnWhatsapp.setOnClickListener {
            val intent = Intent(this, WhatsAppUIActivity::class.java)
            startActivity(intent)
        }
//        btnViewPager.setOnClickListener {
//            val intent = Intent(this, ViewPagerActivity::class.java)
//            startActivity(intent)
//        }
    }
}