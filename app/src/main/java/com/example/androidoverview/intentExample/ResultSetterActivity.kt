package com.example.androidoverview.intentExample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.activity_result_setter.btnLastName
import kotlinx.android.synthetic.main.activity_result_setter.etIntentLastName
import kotlinx.android.synthetic.main.activity_result_setter.tvIntentFirstName

class ResultSetterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_setter)

        val firstName =  intent.extras?.get("firstName")

        firstName.let{ tvIntentFirstName.text = firstName.toString() }
//        if (firstName != null) {
//            tvIntentFirstName.text = firstName.toString()
//        }

        btnLastName.setOnClickListener {
            val intent = Intent(this, ResultIntentActivity::class.java)
            intent.putExtra("lastName",etIntentLastName.text.toString())
            intent.putExtra("firstName", tvIntentFirstName.text.toString())
            startActivity(intent)
//            setResult(RESULT_OK, intent)
//            super.onBackPressed()
        }
    }
}