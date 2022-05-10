package com.example.androidoverview.intentExample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.activity_result_intent.btnFirstName
import kotlinx.android.synthetic.main.activity_result_intent.etIntentFirstName
import kotlinx.android.synthetic.main.activity_result_intent.tvIntentFullName

class ResultIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_intent)
        tvIntentFullName.text = intent.getStringExtra(R.string.first_name.toString()) + intent.getStringExtra(R.string.last_name.toString())

        btnFirstName.setOnClickListener {
            val intent = Intent(this@ResultIntentActivity, ResultSetterActivity::class.java)
            intent.putExtra(R.string.first_name.toString(), etIntentFirstName.text.toString())
            startActivity(intent)
        }
    }
}