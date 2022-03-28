package com.example.androidoverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.chat_item_layout.view.chatImg
import kotlinx.android.synthetic.main.chat_item_layout.view.chatMessage
import kotlinx.android.synthetic.main.chat_item_layout.view.chatName
import kotlinx.android.synthetic.main.chat_item_layout.view.timeStamp

class ChatAdapterClass (private val mList: List<ChatModelClass>) : RecyclerView.Adapter<ChatAdapterClass.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapterClass.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item_layout, parent, false)
        return ChatAdapterClass.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapterClass.ViewHolder, position: Int) {
        val itemsDetails = mList[position]
        holder.chatName.text = itemsDetails.chatName
        holder.chatMessage.text = itemsDetails.chatMessage
        holder.chatTime.text = itemsDetails.chatTime
//        holder.chatImage.setImageResource(itemsDetails.chatImage)
        loadImage(itemsDetails.chatImage, holder.chatImage)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

        class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
            val chatName : TextView = itemView.chatName
            val chatMessage : TextView = itemView.chatMessage
            val chatTime : TextView = itemView.timeStamp
            val chatImage : CircleImageView = itemView.chatImg
        }

}