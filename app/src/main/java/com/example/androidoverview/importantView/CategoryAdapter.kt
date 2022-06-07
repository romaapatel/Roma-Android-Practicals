package com.example.androidoverview.importantView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidoverview.R
import kotlinx.android.synthetic.main.category_recycler_item.view.categoryView

class CategoryAdaptor(val context: Context, private var categories: List<CategoryModelClass> = CategoryModelClass.values().toList()): RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {

    fun setCategories(categories: List<CategoryModelClass>) {
        this.categories = categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryView.text = categories[position].category
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val categoryView : TextView = itemView.categoryView
    }
}