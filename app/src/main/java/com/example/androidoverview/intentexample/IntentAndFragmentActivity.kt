package com.example.androidoverview.intentexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R
import com.example.androidoverview.fragmentExample.FragmentExampleActivity
import kotlinx.android.synthetic.main.activity_intent_and_fragment.btnFragmentWithData
import kotlinx.android.synthetic.main.activity_intent_and_fragment.btnImplicitIntentExample
import kotlinx.android.synthetic.main.activity_intent_and_fragment.btnIntentwithDataPassing

class IntentAndFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_and_fragment)

        btnImplicitIntentExample.setOnClickListener {
            val intent = Intent(this, ImplicitIntentActivity::class.java)
            startActivity(intent)
        }
        btnIntentwithDataPassing.setOnClickListener {
            val intentDataPassing = Intent(this,ResultIntentActivity::class.java)
            startActivity(intentDataPassing)
        }
        btnFragmentWithData.setOnClickListener {
            val intentFragment = Intent(this, FragmentExampleActivity::class.java)
            startActivity(intentFragment)
        }


    }
}