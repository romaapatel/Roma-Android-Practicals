package com.example.androidoverview.architecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R
import com.example.androidoverview.utils.Constant
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_mvcarchitecture.tabLayout
import kotlinx.android.synthetic.main.activity_mvcarchitecture.viewPager

class MVCArchitectureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvcarchitecture)

        viewPager.adapter = MVCViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            when (position) {
                Constant.ZERO -> tab.text = getString(R.string.mvc)
                Constant.ONE -> tab.text = getString(R.string.mvp)
                Constant.TWO -> tab.text = getString(R.string.mvvm)
            }
        }.attach()
    }
}