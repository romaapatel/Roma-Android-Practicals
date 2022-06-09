package com.example.androidoverview.architecture.mvp

import com.example.androidoverview.architecture.APIBaseUrlClass
import com.example.androidoverview.architecture.ResponseModel
import retrofit2.Call

class UserPresenter(val result: UserInterfaceResult) : UserInterfacePresenter {

    override fun getUsers(page: Int) {
        val call = APIBaseUrlClass.getRetrofitObject().getUsers(page)
        call.enqueue(object :  retrofit2.Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>, response: retrofit2.Response<ResponseModel>) {
                if (response.isSuccessful) {
                    response.body()?.let { result.onSuccess(it) }
                } else {
                    result.onApiFailure()
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                result.onFailure()
            }
        })
    }
}