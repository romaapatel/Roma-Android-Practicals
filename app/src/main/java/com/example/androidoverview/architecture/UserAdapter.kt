package com.example.androidoverview.architecture

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidoverview.R
import com.example.androidoverview.loadCircleImage
import kotlinx.android.synthetic.main.recycler_user_item.view.ivUserImage
import kotlinx.android.synthetic.main.recycler_user_item.view.tvUserEmail
import kotlinx.android.synthetic.main.recycler_user_item.view.tvUserName

class UsersAdapter(val context: Context, private var users: List<User>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {
            with (users[position]) {
                loadCircleImage(avatar, userImage)
                userName.text = first_name + last_name
                userEmail.text = email
            }
        }

    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.tvUserName
        val userEmail: TextView = itemView.tvUserEmail
        val userImage: ImageView = itemView.ivUserImage
    }
}