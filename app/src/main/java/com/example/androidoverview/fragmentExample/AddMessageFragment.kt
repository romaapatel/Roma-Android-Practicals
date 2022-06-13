package com.example.androidoverview.fragmentExample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.fragment_add_message.view.etAddMessage

class AddMessageFragment : Fragment() {

    private val viewModel : ScoreViewModel by activityViewModels()

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_message, container, false)
        view.etAddMessage.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(charSequence: CharSequence?, stringFirst: Int, stringSecond: Int, stringThird: Int) {
            }

            override fun onTextChanged(charSequence : CharSequence?, stringFrist : Int, stringSecond : Int, stringThird : Int) {
                viewModel.setMessage(charSequence.toString())
            }

            override fun afterTextChanged(editable : Editable?) {
            }
        })
        return view
    }

}