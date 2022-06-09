package com.example.androidoverview.architecture

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidoverview.architecture.mvp.MVPFragment
import com.example.androidoverview.architecture.mvvm.MVVMFragment
import com.example.androidoverview.utils.Constant

class MVCViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return  Constant.THREE
    }

    override fun createFragment(position: Int): Fragment {
        return  when (position) {
            Constant.ZERO -> MVCFragment()
            Constant.ONE -> MVPFragment()
            Constant.TWO -> MVVMFragment()
            else -> Fragment()
        }
    }
}