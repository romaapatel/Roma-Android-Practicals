package com.example.androidoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_delicious_acitivity.imageDelicious

class DeliciousFragmentActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delicious_acitivity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNkCnwH8IgGMC8rxBhLmBc02kRvprz-n97g-lttlcIAjkvmXbOVFd4y-HcTeBOByRTcZc&usqp=CAU", imageDelicious)
    }

}