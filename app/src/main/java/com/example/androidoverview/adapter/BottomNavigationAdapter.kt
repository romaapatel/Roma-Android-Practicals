package com.example.androidoverview.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidoverview.fragmentExample.AddMessageFragment
import com.example.androidoverview.fragmentExample.GalleryFragment
import com.example.androidoverview.fragmentExample.ViewMessageFragment
import com.example.androidoverview.utils.Constant

class BottomNavigationAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return Constant.THREE
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            Constant.ZERO -> GalleryFragment()
            Constant.ONE -> AddMessageFragment()
            Constant.TWO -> ViewMessageFragment()
            else -> GalleryFragment()
        }
    }
}