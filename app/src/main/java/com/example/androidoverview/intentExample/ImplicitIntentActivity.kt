package com.example.androidoverview.intentExample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.activity_implicit_intent.btnCall
import kotlinx.android.synthetic.main.activity_implicit_intent.btnLocation
import kotlinx.android.synthetic.main.activity_implicit_intent.btnMessage
import kotlinx.android.synthetic.main.activity_implicit_intent.btnUrl
import kotlinx.android.synthetic.main.activity_implicit_intent.etCall
import kotlinx.android.synthetic.main.activity_implicit_intent.etLocation
import kotlinx.android.synthetic.main.activity_implicit_intent.etMessage
import kotlinx.android.synthetic.main.activity_implicit_intent.etUrl

class ImplicitIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)
        btnUrl.setOnClickListener {
            openWebsite()
        }
        btnLocation.setOnClickListener {
            getLocation()
        }
        btnMessage.setOnClickListener {
            shareMessage()
        }
        btnCall.setOnClickListener {
            doCall()
        }

    }
    private fun openWebsite() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(etUrl.text.toString()))
        startActivity(intent)
    }

    private fun getLocation() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + etLocation.text.toString()))
        startActivity(intent)
    }

    private fun shareMessage() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra( Intent.EXTRA_TEXT,etMessage.text.toString())
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent,"Share Via"))
    }

    private fun doCall() {
       val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:"+ etCall.text.toString())
        startActivity(dialIntent)
    }
}