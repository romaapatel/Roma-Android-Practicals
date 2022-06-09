package com.example.androidoverview.architecture

import com.example.androidoverview.utils.Constant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET(Constant.reqUrl)
    fun getUsers(@Query("page") pageId: Int): Call<ResponseModel>
}