package com.example.androidoverview.fragmentExample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R

class AnotherFlexibleUIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another_flexible_ui)
        supportFragmentManager.findFragmentById(R.id.fragmentDescription) as DescriptionFragment
    }
}