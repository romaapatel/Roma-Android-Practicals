package com.example.androidoverview.intentExample

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
            val intent = Intent(this@IntentAndFragmentActivity, ImplicitIntentActivity::class.java)
            startActivity(intent)
        }

        btnIntentwithDataPassing.setOnClickListener {
            val intentDataPassing = Intent(this@IntentAndFragmentActivity, ResultIntentActivity::class.java)
            startActivity(intentDataPassing)
        }

        btnFragmentWithData.setOnClickListener {
            val intentFragment = Intent(this@IntentAndFragmentActivity, FragmentExampleActivity::class.java)
            startActivity(intentFragment)
        }
    }
}