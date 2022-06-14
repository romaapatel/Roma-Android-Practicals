package com.example.androidoverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chat_item_layout.view.chatImg
import kotlinx.android.synthetic.main.chat_item_layout.view.chatMessage
import kotlinx.android.synthetic.main.chat_item_layout.view.chatName
import kotlinx.android.synthetic.main.chat_item_layout.view.timeStamp

class ChatAdapterClass(private val chatList: List<ChatModelClass>) :
    RecyclerView.Adapter<ChatAdapterClass.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapterClass.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item_layout, parent, false)
        return ChatAdapterClass.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapterClass.ViewHolder, position: Int) {
        val itemsDetails = chatList[position]
        holder.apply {
            chatName.text = itemsDetails.chatName
            chatMessage.text = itemsDetails.chatMessage
            chatTime.text = itemsDetails.chatTime
            loadCircleImage(itemsDetails.chatImage, chatImage)
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chatName: TextView = this.itemView.chatName
        val chatMessage: TextView = this.itemView.chatMessage
        val chatTime: TextView = this.itemView.timeStamp
        val chatImage: ImageView = this.itemView.chatImg
    }
}