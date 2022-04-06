package com.example.androidoverview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.btnSignIn
import kotlinx.android.synthetic.main.activity_sign_in.tvSignUp

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        btnSignIn.setOnClickListener {
            Toast.makeText(this, getString(R.string.welcome_to_instagram), Toast.LENGTH_SHORT).show()
        }
        tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUPActivity::class.java)
            startActivity(intent)
        }
    }
}