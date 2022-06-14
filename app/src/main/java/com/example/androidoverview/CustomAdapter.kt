package com.example.androidoverview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.imageViewRowFile
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.tvAge
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.tvContact
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.tvName

class CustomAdapter(private val detailsList: List<ItemModelClass>, val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val itemsDetails = detailsList[position]
        holder.apply {
            name.text = itemsDetails.name
            age.text = itemsDetails.age
            contact.text = itemsDetails.contact
            loadCircleImage(itemsDetails.itemImage, itemImage)
        }
    }

    override fun getItemCount(): Int {
        return detailsList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val name: TextView = itemView.tvName
        val age: TextView = itemView.tvAge
        val contact: TextView = itemView.tvContact
        val itemImage: ImageView = itemView.imageViewRowFile
    }
}