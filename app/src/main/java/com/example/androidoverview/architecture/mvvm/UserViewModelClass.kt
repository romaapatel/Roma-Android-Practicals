package com.example.androidoverview.architecture.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidoverview.architecture.User

class UserViewModelClass: ViewModel() {

    private var users: MutableLiveData<List<User>> = MutableLiveData()
    lateinit var repositry: UsersRepositryClass

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    fun init() {
        repositry = UsersRepositryClass.getRepoInstance()
        users = repositry.getUsers()
    }
}