package com.example.androidoverview.fragmentExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.fragment_quiz_game_main_page.view.btnStartGame
import kotlinx.android.synthetic.main.fragment_quiz_game_main_page.view.tvTotalScore


class QuizGameMainPage : Fragment() {

    private val viewModel: ScoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_game_main_page, container, false)
        view.btnStartGame.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frameLayoutFragment, GameFragmentActivity())?.commit()
        }

        val result = "Your Score"

        viewModel.getTotalQuestions().observe(viewLifecycleOwner, Observer {
            view.tvTotalScore.text = it.toString()
        })

        viewModel.getScore().observe(viewLifecycleOwner, Observer {
            view.tvTotalScore.text = view.tvTotalScore.text.toString() + "/" + it.toString()
        })

        view.tvTotalScore.text = result

        return view
    }
}