package com.example.androidoverview.fragmentExample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.fragment_city_list.listViewCity

class CityListFragment : Fragment(),  AdapterView.OnItemClickListener {

    private val viewModel: ScoreViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_city_list, container, false)
        listViewCity.onItemClickListener = this
        return view
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
       viewModel.setContextViewModel(requireContext())
       viewModel.updateData(p2)
       requireActivity().supportFragmentManager.beginTransaction().add(R.id.fragmentDescription, DescriptionFragment())
    }

}