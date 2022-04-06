package com.example.androidoverview.intentexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.androidoverview.R

class RecieverIntentClass : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, R.string.wake_up, Toast.LENGTH_SHORT).show()
    }
}