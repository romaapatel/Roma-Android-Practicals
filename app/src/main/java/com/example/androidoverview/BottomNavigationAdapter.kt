package com.example.androidoverview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidoverview.utils.Constant

class BottomNavigationAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return Constant.THREE
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            Constant.ZERO -> {
                HomeFragmentActivity()
            }
            Constant.ONE -> {
                HomeFragmentActivity()
            }
            Constant.TWO -> {
                HomeFragmentActivity()
            }
            else -> {
                Fragment()
            }
        }
    }
}