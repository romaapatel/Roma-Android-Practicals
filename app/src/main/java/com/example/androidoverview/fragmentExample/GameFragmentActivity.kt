package com.example.androidoverview.fragmentExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.btnqustionSubmit
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.rgOptions
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvFragmentScore
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvquestion
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvquestionNumber


class GameFragmentActivity : Fragment() {

    private val viewModel: ScoreViewModel by activityViewModels()
    private lateinit var questions: MutableList<QuestionModelClass>
    var counter = 0
    var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_actitvity, container, false)

        questions = ArrayList()

        questions.add(
            QuestionModelClass(
                " What is ART?",
                arrayOf("Android Reaction Time", "Android Run Tool", "Android Run Time", "None"),
                "Android Run Time"
            )
        )
        questions.add(
            QuestionModelClass(
                " What is Android?",
                arrayOf("Android Reaction Time", "Android Run Tool", "Android", "None"),
                "Android"
            )
        )

        updateQuestion(view)

        view.btnqustionSubmit.setOnClickListener {
            checkQuestion(view.rgOptions.checkedRadioButtonId.toString())
            counter++
            updateQuestion(view)
        }

        return view
    }

    private fun checkQuestion(selectedAnswer: String) {
        if(selectedAnswer == questions[counter].ans) {
            score++
        }
        viewModel.setScore(score)
        viewModel.setTotalQuestions(questions.size)
    }

    private fun updateQuestion(view: View) {
        if(counter < questions.size) {
            view.rgOptions.removeAllViews()
            view.tvquestion.text = questions[counter].question
            view.tvFragmentScore.text = score.toString()
            view.tvquestionNumber.text = (counter + 1).toString() + "/" + questions.size.toString()
            view.rgOptions.orientation = LinearLayout.VERTICAL

            for (i in questions[counter].options) {
                val answerbtn = RadioButton(context)
                answerbtn.id = View.generateViewId()
                answerbtn.text = i
                view.rgOptions.addView(answerbtn)
            }
        } else {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frameLayoutFragment, QuizGameMainPage())?.commit()
        }

    }
}