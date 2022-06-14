package com.example.androidoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidoverview.utils.Constant
import kotlinx.android.synthetic.main.fragment_delicious_acitivity.ivDelicious

class DeliciousFragmentActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_delicious_acitivity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage(Constant.IMAGE_DELICIOUS, ivDelicious)
    }

}