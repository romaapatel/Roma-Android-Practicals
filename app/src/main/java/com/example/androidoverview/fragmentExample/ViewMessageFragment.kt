package com.example.androidoverview.fragmentExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.fragment_view_message.tvViewMessage

class ViewMessageFragment : Fragment()  {
    private val viewModel: ScoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_message, container, false)
        viewModel.getMessage().observe(viewLifecycleOwner, androidx.lifecycle.Observer { message ->
            this.tvViewMessage.text = message
        })
        return view
    }
}