package com.example.androidoverview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableListViewAdapter internal constructor(
    private val context: Context,
    private  val titleList : List<String>,
    private val dataList : MutableList<List<String>>
):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return dataList[p0].count()
    }

    override fun getGroup(p0: Int): String {
        return titleList[p0]
    }

    override fun getChild(p0: Int, p1: Int): String {
        return dataList[p0][p1]
    }

    override fun getGroupId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View? {
        var view = p2

        if(view == null) {
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.expandable_grouplist_layout,null)
        }
        var brandName = view?.findViewById<TextView>(R.id.tvExpandableTitle)
        brandName?.text = getGroup(p0)
        return view

    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View? {
        var view = p3
        if (view == null) {
            var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.expandable_childlist_layout,null)
        }
        var seriesName = view?.findViewById<TextView>(R.id.tvExpandableData)
        seriesName?.text = getChild(p0, p1)
        return view
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}