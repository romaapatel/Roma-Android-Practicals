package com.example.androidoverview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.imageViewRowFile
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.tvAge
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.tvContact
import kotlinx.android.synthetic.main.recyclerview_item_layout.view.tvName

class CustomAdapter(private val mList: List<ItemModelClass>, val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val itemsDetails = mList[position]
        holder.name.text = itemsDetails.name
        holder.age.text = itemsDetails.age
        holder.contact.text = itemsDetails.contact
        loadImage(itemsDetails.itemImage,holder.itemImage)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val name : TextView = itemView.tvName
        val age : TextView = itemView.tvAge
        val contact : TextView = itemView.tvContact
        val itemImage : CircleImageView = itemView.imageViewRowFile
    }

}