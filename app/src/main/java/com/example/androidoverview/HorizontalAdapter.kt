package com.example.androidoverview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.horizontal_item_layout.view.imageMovie
import kotlinx.android.synthetic.main.horizontal_item_layout.view.layoutMovieDetails
import kotlinx.android.synthetic.main.horizontal_item_layout.view.tvMovieDetails
import kotlinx.android.synthetic.main.horizontal_item_layout.view.tvMovieName

class HorizontalAdapter (private val mList : List<HorizontalModelClass> , val context: Context ): RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.horizontal_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = mList[position]

        loadImage(currentMovie.imageHorizontal,holder.image)
        holder.movieName.text = currentMovie.name
        holder.movieDetails.text = currentMovie.details

        holder.itemView.setOnClickListener{
            if(holder.movieLayout.visibility == View.GONE) {
                holder.movieLayout.visibility = View.VISIBLE
            } else if(holder.movieLayout.visibility == View.VISIBLE){
                holder.movieLayout.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
       val image: ImageView = itemView.imageMovie
       val movieName: TextView = itemView.tvMovieName
       val movieDetails: TextView = itemView.tvMovieDetails
       val movieLayout: LinearLayout = itemView.layoutMovieDetails
    }
}
