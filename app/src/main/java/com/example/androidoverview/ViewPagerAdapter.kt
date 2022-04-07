package com.example.androidoverview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidoverview.utils.Constant

class ViewPagerAdapter(fragmentManager: FragmentManager, lifeCycle : Lifecycle) : FragmentStateAdapter(fragmentManager, lifeCycle) {

    override fun getItemCount(): Int {
        return Constant.THREE
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            Constant.ZERO -> {
                TastyFragmentActivity()
            } Constant.ONE -> {
                DeliciousFragmentActivity()
            } Constant.TWO -> {
                SweetFragmentActivity()
            } else -> {
                Fragment()
            }
        }
    }
}