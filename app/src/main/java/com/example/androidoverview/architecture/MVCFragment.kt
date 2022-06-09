package com.example.androidoverview.architecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidoverview.R
import com.example.androidoverview.utils.Constant
import kotlinx.android.synthetic.main.fragment_mvc.usersRecyclerView
import retrofit2.Call

class MVCFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mvc, container, false)
        getUsers(Constant.TWO)
        return view
    }

    private fun getUsers(page : Int) {
        val call = APIBaseUrlClass.getRetrofitObject().getUsers(page)
        call.enqueue(object : retrofit2.Callback<com.example.androidoverview.architecture.ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>, response: retrofit2.Response<ResponseModel>) {
                if (response.isSuccessful) {
                    val data = response.body()!!
                    usersRecyclerView.adapter = UsersAdapter(requireContext(), data.data)
                } else {
                    Toast.makeText(requireContext(), R.string.something_went_wrong_on_api_side, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(requireContext(), R.string.something_went_wrong_on_device_side, Toast.LENGTH_SHORT).show()
            }
        })
    }
}