package com.example.androidoverview.importantView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidoverview.R
import com.example.androidoverview.loadImage
import kotlinx.android.synthetic.main.movie_layout_recycler_item.view.movieCategory
import kotlinx.android.synthetic.main.movie_layout_recycler_item.view.movieImage
import kotlinx.android.synthetic.main.movie_layout_recycler_item.view.movieName

class MovieAdaptor(val context: Context, private var movies: List<MovieDetailModelClass>) :
    RecyclerView.Adapter<MovieAdaptor.ViewHolder>() {

     fun setMovies(movies: List<MovieDetailModelClass>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_layout_recycler_item, parent, false)
        return MovieAdaptor.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieDetails = movies[position]
        holder.apply {
            with(movies[position]) {
                loadImage(movieDetails.poster, movieImage)
                movieName.text = movieDetails.name
                movieCategory.text = movieDetails.category.category
            }
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val movieName : TextView = itemView.movieName
        val movieCategory : TextView = itemView.movieCategory
        val movieImage : ImageView = itemView.movieImage
    }
}