package com.example.androidoverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.recyclerViewLayout

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerViewLayout.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(details,this)
        recyclerViewLayout.adapter = adapter

        recyclerViewLayout.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                (recyclerViewLayout.layoutManager as LinearLayoutManager).orientation
            )
        )
    }
}