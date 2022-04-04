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
import com.example.androidoverview.utils.Constant
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.btnqustionSubmit
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.rgOptions
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvFragmentScore
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvquestion
import kotlinx.android.synthetic.main.fragment_game_actitvity.view.tvquestionNumber


class GameFragmentActivity : Fragment() {

    private val viewModel: ScoreViewModel by activityViewModels()
    private lateinit var questions: MutableList<QuestionModelClass>
    var counter = Constant.ZERO
    var score = Constant.ZERO

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game_actitvity, container, false)
        questions = ArrayList()
        questions.add(
            QuestionModelClass(
                R.string.what_is_art.toString(),
                arrayOf(R.string.android_reaction_time.toString(), R.string.android_run_time.toString(),R.string.android_run_tool.toString(),R.string.none.toString()),
                R.string.android_run_time.toString()
            )
        )
        questions.add(
            QuestionModelClass(
                R.string.what_is_android.toString(),
                arrayOf(R.string.android_reaction_time.toString(),R.string.android_run_tool.toString(),R.string.none.toString(),R.string.android.toString() ),
                R.string.android.toString()
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
            for (answer in questions[counter].options) {
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