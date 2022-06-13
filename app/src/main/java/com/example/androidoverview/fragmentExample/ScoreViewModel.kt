package com.example.androidoverview.fragmentExample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidoverview.R

class ScoreViewModel: ViewModel() {

    var score: MutableLiveData<Int> = MutableLiveData()
    var totalQuestions: MutableLiveData<Int> = MutableLiveData()
    var message: MutableLiveData<String> = MutableLiveData()
    var data: MutableLiveData<String> = MutableLiveData()
    var descriptionArray : Array<String> = emptyArray()
    lateinit var context: Context

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

    fun setContextViewModel(context: Context) {
        this.context = context
    }

    fun setMessage(message: String) {
        this.message.value = message
    }

    fun getMessage(): LiveData<String> {
        return message
    }

    fun updateData(index: Int) {
        descriptionArray = context.resources.getStringArray(R.array.description_array)
        data.value =  descriptionArray[index]
    }

    fun getData() : LiveData<String> {
        return data
    }
}