package com.example.androidoverview.fragmentExample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel: ViewModel() {

    var score: MutableLiveData<Int> = MutableLiveData()
    var totalQuestions: MutableLiveData<Int> = MutableLiveData()

    fun setScore(score: Int) {
        this.score.value = score
    }

    fun getScore(): LiveData<Int> {
        return score
    }

    fun setTotalQuestions(numberOfQuestions: Int) {
        totalQuestions.value = numberOfQuestions
    }

    fun getTotalQuestions(): LiveData<Int> {
        return totalQuestions
    }
}