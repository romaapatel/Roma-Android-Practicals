package com.example.androidoverview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.bottomNav
import kotlinx.android.synthetic.main.activity_view_pager.framePager
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
                0 -> {
                    tab.text = "Tasty"
                } 1 -> {
                    tab.text = "Delicious"
                } 2 -> {
                    tab.text = "Sweet"
                }
            }
        }.attach()

        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navHome -> {
                    viewPager.visibility = View.GONE
                    framePager.visibility = View.VISIBLE
                    supportFragmentManager.beginTransaction().add(R.id.framePager,HomeFragmentActivity()).commit()
                    Toast.makeText(this, "Home Clicker", Toast.LENGTH_SHORT).show()
                }
                R.id.navFavourite -> {
                    viewPager.currentItem = 1
                }
                R.id.navSearch -> {
                    viewPager.currentItem = 2
                    Toast.makeText(this, "InSearch", Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnItemSelectedListener true
        }

        val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> bottomNav.menu.findItem(R.id.navHome).isChecked = true
                    1 -> bottomNav.menu.findItem(R.id.navFavourite).isChecked = true
                    2 -> bottomNav.menu.findItem(R.id.navSearch).isChecked = true
                }
            }
        }
        viewPager.registerOnPageChangeCallback(pageChangeCallback)
    }
}