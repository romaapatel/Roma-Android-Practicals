package com.example.androidoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home_activity.imageHome

class HomeFragmentActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage("data:image/jpeg;base64,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",imageHome)
    }
}