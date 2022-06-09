package com.example.androidoverview.architecture

import com.example.androidoverview.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIBaseUrlClass {

    companion object {
        private val okHttpClientBuilder = OkHttpClient.Builder()
        fun getRetrofitObject(): APIInterface {
            return Retrofit.Builder().baseUrl(Constant.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build()).build().create(APIInterface::class.java)
        }
    }
}