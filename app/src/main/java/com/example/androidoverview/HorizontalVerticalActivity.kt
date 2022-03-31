package com.example.androidoverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_horizontal_vertical_avtivity.recyclerViewParent

class HorizontalVerticalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_vertical_avtivity)
        recyclerViewParent.layoutManager = LinearLayoutManager(this)
        val adapter = VerticalAdapter(listOf("Hindi", "English", "Korean", "Gujarati", "Other"),this, getData)
        recyclerViewParent.adapter = adapter
    }
}