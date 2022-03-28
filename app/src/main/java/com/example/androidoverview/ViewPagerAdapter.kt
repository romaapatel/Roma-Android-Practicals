package com.example.androidoverview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifeCycle : Lifecycle) : FragmentStateAdapter(fragmentManager, lifeCycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> {
                TastyFragmentActivity()
            } 1 -> {
                DeliciousFragmentActivity()
            } 2 -> {
                SweetFragmentActivity()
            } else -> {
                Fragment()
            }
        }
    }
}