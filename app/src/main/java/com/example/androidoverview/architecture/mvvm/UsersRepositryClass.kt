package com.example.androidoverview.architecture.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.androidoverview.R
import com.example.androidoverview.architecture.APIBaseUrlClass
import com.example.androidoverview.architecture.ResponseModel
import com.example.androidoverview.architecture.User
import com.example.androidoverview.utils.Constant
import retrofit2.Call

class UsersRepositryClass {

    val users: ArrayList<User> = ArrayList()

    companion object {
        lateinit var instance: UsersRepositryClass
        fun getRepoInstance(): UsersRepositryClass {
            if(!this::instance.isInitialized) {
                instance = UsersRepositryClass()
            }
            return instance
        }
    }

    fun getUsers(): MutableLiveData<List<User>> {
        val userList: MutableLiveData<List<User>> = MutableLiveData()
        val call = APIBaseUrlClass.getRetrofitObject().getUsers(Constant.TWO)
        call.enqueue(object :
            retrofit2.Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: retrofit2.Response<ResponseModel>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    userList.value = data?.data
                }
            }

            override fun onFailure(call: Call<ResponseModel>, throwable: Throwable) {
                Log.d(R.string.error.toString(),R.string.error.toString())
            }
        })
        return userList
    }

}