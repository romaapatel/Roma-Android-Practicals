package com.example.androidoverview.architecture.mvp

import com.example.androidoverview.architecture.ResponseModel

interface UserInterfaceResult {
    fun onSuccess(response: ResponseModel)
    fun onApiFailure()
    fun onFailure()
}