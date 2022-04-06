package com.example.androidoverview.intentexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.androidoverview.R
import com.example.androidoverview.R.id.fragmentTitle
import com.example.androidoverview.fragmentExample.CityListFragment

class FlexibleUIActivity : AppCompatActivity(){

    lateinit var manager : FragmentManager
    lateinit var citylistFragment : CityListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flexible_uiactivity)
        manager = supportFragmentManager
        citylistFragment = manager.findFragmentById(fragmentTitle) as CityListFragment
    }
}