package com.example.androidoverview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_expandable_list_view.expandableListViewLayout

class ExpandableListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val titleList: MutableList<String> = mutableListOf()
        val dataList: MutableList<List<String>> = mutableListOf()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_list_view)

        titleList.add("AkshayKumar")
        titleList.add("SalmanKhan")
        titleList.add("RanbirSingh")
        titleList.add("Amitabh Bhachhan")

        val akshayMovie = mutableListOf<String>()
        akshayMovie.add("SooryaVanshi")
        akshayMovie.add("Bhool Bhoolaiya")
        akshayMovie.add("Gabbar")

        val salmanMovie = mutableListOf<String>()
        salmanMovie.add("Tere Naam")
        salmanMovie.add("Hum Dil De Chuke Sanam")
        salmanMovie.add("Hum Saath Saath Hai")

        val ranbirMovie = mutableListOf<String>()
        ranbirMovie.add("83")
        ranbirMovie.add("RamLeela")
        ranbirMovie.add("Simmba")

        val amitabhMovie = mutableListOf<String>()
        amitabhMovie.add("Pink")
        amitabhMovie.add("Jhund")
        amitabhMovie.add("102 not Out")

        dataList.add(akshayMovie)
        dataList.add(salmanMovie)
        dataList.add(ranbirMovie)
        dataList.add(amitabhMovie)

       val adapter = ExpandableListViewAdapter(this,titleList,dataList)
        expandableListViewLayout.setAdapter(adapter)
    }
}