package com.example.androidoverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_example.listViewLayout

class ListExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_example)

        val adapter = ListAdapter(this, listData as ArrayList<ListModelClass>)
        listViewLayout.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}