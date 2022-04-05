package com.example.androidoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sweet_activity.imageSweet

class SweetFragmentActivity : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sweet_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFM4md2eXYtjdfxgpQk0X0BwtqHXZqF4gbPwNgWyKNN6Ue5iJn7x__D3VhdsHfcundwDQ&usqp=CAU",imageSweet)
    }
}