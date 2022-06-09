package com.example.androidoverview.architecture.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidoverview.R
import com.example.androidoverview.architecture.ResponseModel
import com.example.androidoverview.architecture.UsersAdapter
import com.example.androidoverview.utils.Constant
import kotlinx.android.synthetic.main.fragment_mvc.usersRecyclerView

class MVPFragment : Fragment() {

    lateinit var presenter: UserPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_m_v_p, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = UserPresenter(object : UserInterfaceResult {
            override fun onSuccess(response: ResponseModel) {
                usersRecyclerView.adapter = UsersAdapter(requireContext(), response.data)
            }

            override fun onApiFailure() {
                Toast.makeText(requireContext(), R.string.something_went_wrong_on_api_side, Toast.LENGTH_SHORT).show()
            }

            override fun onFailure() {
                Toast.makeText(requireContext(), R.string.something_went_wrong_on_device_side, Toast.LENGTH_SHORT).show()
            }
        })
        presenter.getUsers(Constant.TWO)
    }
}