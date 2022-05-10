package com.example.androidoverview.fragmentExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.androidoverview.R
import com.example.androidoverview.utils.Constant
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.btnQuestionSubmit
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.rgOptions
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvFragmentScore
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvQuestion
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvQuestionNumber

class GameFragmentActivity : Fragment() {

    private val viewModel: ScoreViewModel by activityViewModels()
    private lateinit var questionsList: MutableList<QuestionModelClass>
    private var counter = Constant.ZERO
    private var score = Constant.ZERO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_actitvity, container, false)
        questionsList = ArrayList()
        questionsList.add(QuestionModelClass(getString(R.string.what_is_art), resources.getStringArray(R.array.answer_list), R.string.android_run_time.toString()))
        questionsList.add(QuestionModelClass(getString(R.string.what_is_android), resources.getStringArray(R.array.answer_list), R.string.android.toString()))
        updateQuestion(view)

        view.btnQuestionSubmit.setOnClickListener {
            checkQuestion(view.rgOptions.checkedRadioButtonId.toString())
            counter++
            updateQuestion(view)
        }
        return view
    }

    private fun checkQuestion(selectedAnswer: String) {
        if (selectedAnswer == questionsList[counter].ans) {
            score++
        }
        viewModel.setScore(score)
        viewModel.setTotalQuestions(questionsList.size)
    }

    private fun updateQuestion(view: View) {
        if (counter < questionsList.size) {
            view.rgOptions.removeAllViews()
            view.tvQuestion.text = questionsList[counter].question
            view.tvFragmentScore.text = score.toString()
            view.tvQuestionNumber.text = (counter + 1).toString()
            for (answer in questionsList[counter].options) {
                val answerBtn = RadioButton(context)
                answerBtn.id = View.generateViewId()
                answerBtn.text = answer
                view.rgOptions.addView(answerBtn)
            }
        } else {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frameLayoutFragment, QuizGameMainPage())?.commit()
        }
    }
}