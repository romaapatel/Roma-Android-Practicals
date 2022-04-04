package com.example.androidoverview.intentexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R
import com.example.androidoverview.utils.Constant
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
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(Constant.LOCATION + etLocation.text.toString()))
        startActivity(intent)
    }

    private fun shareMessage() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra( Intent.EXTRA_TEXT,etMessage.text.toString())
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent,Constant.SHARE_VIA))
    }

    private fun doCall() {
       val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse(Constant.TEL+ etCall.text.toString())
        startActivity(dialIntent)
    }
}