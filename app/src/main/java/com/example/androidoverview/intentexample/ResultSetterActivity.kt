package com.example.androidoverview.intentexample

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

        val firstName =  intent.extras?.get(R.string.first_name.toString())

        firstName.let{ tvIntentFirstName.text = firstName.toString() }
        btnLastName.setOnClickListener {
            val intent = Intent(this, ResultIntentActivity::class.java)
            intent.putExtra(R.string.last_name.toString(),etIntentLastName.text.toString())
            intent.putExtra(R.string.first_name.toString(), tvIntentFirstName.text.toString())
            startActivity(intent)
        }
    }
}