package com.example.androidoverview.architecture.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidoverview.R
import com.example.androidoverview.architecture.User
import com.example.androidoverview.architecture.UsersAdapter
import kotlinx.android.synthetic.main.fragment_mvc.usersRecyclerView

class MVVMFragment : Fragment() {

    lateinit var viewModelClass: UserViewModelClass
     lateinit var userAdapter : UsersAdapter
    private val users: List<User> = ArrayList()

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userAdapter = UsersAdapter(requireContext(), users)
        val view =  inflater.inflate(R.layout.fragment_m_v_v_m, container, false)
        viewModelClass = ViewModelProvider(this)[UserViewModelClass::class.java]
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelClass.init()
        viewModelClass.getUsers().observe(viewLifecycleOwner) {
            userAdapter.setUsers(it)
        }
        usersRecyclerView.adapter = userAdapter
    }
}