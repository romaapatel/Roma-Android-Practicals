package com.example.androidoverview.fragmentExample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel: ViewModel() {

    var score: MutableLiveData<Int> = MutableLiveData()
    var totalQuestions: MutableLiveData<Int> = MutableLiveData()

    fun setScore(s: Int) {
        this.score.value = s
    }
    fun getScore(): LiveData<Int> {
        return score
    }

    fun setTotalQuestions(t: Int) {
        totalQuestions.value = t
    }
    fun getTotalQuestions(): LiveData<Int> {
        return totalQuestions
    }

}