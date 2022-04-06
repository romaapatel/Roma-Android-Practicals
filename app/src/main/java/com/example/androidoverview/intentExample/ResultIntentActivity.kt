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

        tvIntentFullName.text = intent.getStringExtra("firstName")+ " "+ intent.getStringExtra("lastName")
        btnFirstName.setOnClickListener {
            var intent = Intent(this,ResultSetterActivity::class.java)
            intent.putExtra( "firstName", etIntentFirstName.text.toString())
            startActivity(intent)
        }
    }
}