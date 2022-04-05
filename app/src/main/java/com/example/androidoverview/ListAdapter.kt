package com.example.androidoverview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_item_layout.view.imageIcon
import kotlinx.android.synthetic.main.list_item_layout.view.tvListContact
import kotlinx.android.synthetic.main.list_item_layout.view.tvListName

class ListAdapter(private val context: Activity, private val arrayList: ArrayList<ListModelClass>) :
    ArrayAdapter<ListModelClass>(context, R.layout.list_item_layout, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item_layout, null)
        val currentUser: ListModelClass = arrayList[position]
        loadImage(currentUser.image, view.imageIcon)
//        view.imageIcon.setImageResource(currentUser.image)
        view.tvListName.text = currentUser.listName
        view.tvListContact.text = currentUser.listContact
        return view
    }
}