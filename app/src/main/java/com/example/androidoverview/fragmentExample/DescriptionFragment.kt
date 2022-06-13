package com.example.androidoverview.fragmentExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.fragment_description.view.tvDescription

class DescriptionFragment : Fragment() {

    private val viewModel: ScoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_description, container, false)
        viewModel.getData().observe(viewLifecycleOwner, Observer { description ->
            view.tvDescription.text = description
        })
        return view
    }
}