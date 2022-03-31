package com.example.androidoverview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BottomNavigationAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> {
                HomeFragmentActivity()
            } 1 -> {
                HomeFragmentActivity()
            } 2 -> {
                HomeFragmentActivity()
            } else -> {
                Fragment()
            }
        }
    }
}