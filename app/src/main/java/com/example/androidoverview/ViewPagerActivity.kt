package com.example.androidoverview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.androidoverview.utils.Constant
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.bottomNav
import kotlinx.android.synthetic.main.activity_view_pager.flPager
import kotlinx.android.synthetic.main.activity_view_pager.tabLayout
import kotlinx.android.synthetic.main.activity_view_pager.viewPager

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                Constant.ZERO -> {
                    tab.text = R.string.tasty.toString()
                } Constant.ONE -> {
                    tab.text = R.string.delicious.toString()
                } Constant.TWO -> {
                    tab.text = R.string.sweet.toString()
                }
            }
        }.attach()

        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navHome -> {
                    viewPager.visibility = View.GONE
                    flPager.visibility = View.VISIBLE
                    supportFragmentManager.beginTransaction().add(R.id.flPager, HomeFragmentActivity()).commit()
                    Toast.makeText(this, R.string.home_click, Toast.LENGTH_SHORT).show()
                }
                R.id.navFavourite -> {
                    viewPager.currentItem = Constant.ONE
                }
                R.id.navSearch -> {
                    viewPager.currentItem = Constant.TWO
                    Toast.makeText(this, R.string.search_click, Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnItemSelectedListener true
        }

        val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    Constant.ZERO-> bottomNav.menu.findItem(R.id.navHome).isChecked = true
                    Constant.ONE -> bottomNav.menu.findItem(R.id.navFavourite).isChecked = true
                    Constant.TWO -> bottomNav.menu.findItem(R.id.navSearch).isChecked = true
                }
            }
        }
        viewPager.registerOnPageChangeCallback(pageChangeCallback)
    }
}