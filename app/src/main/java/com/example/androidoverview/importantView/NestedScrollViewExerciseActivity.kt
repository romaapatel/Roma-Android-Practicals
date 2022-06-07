package com.example.androidoverview.importantView

import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidoverview.R
import com.example.androidoverview.loadImage
import com.example.androidoverview.utils.Constant
import com.example.androidoverview.utils.Constant.MAX_PROGRESS
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.backButton
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.categoryRecycler
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.ivDiscovery
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.ivHboMax
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.ivHotStar
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.ivNetflix
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.ivShemaroMe
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.productsRecycler
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.progressBar
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.searchBar
import kotlinx.android.synthetic.main.activity_nested_scroll_view_exercise.webView

class NestedScrollViewExerciseActivity : AppCompatActivity(), View.OnClickListener {

    var filteredListMovieList = getData.toMutableList()
    var categoryList = CategoryModelClass.values().toList()
    var filteredCategoryList = categoryList.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll_view_exercise)
        val categoryAdaptor = CategoryAdaptor(this@NestedScrollViewExerciseActivity)
        val movieAdaptor = MovieAdaptor(this@NestedScrollViewExerciseActivity, getData.toMutableList())
            loadImage(Constant.NETFLIX_IMG, ivNetflix)
            loadImage(Constant.SHEMARROO_IMG, ivShemaroMe)
            loadImage(Constant.HBOMAX_IMG, ivHboMax)
            loadImage(Constant.DISCOVERY_IMG, ivDiscovery)
            loadImage(Constant.HOTSTAR_IMG, ivHotStar)
            ivNetflix.setOnClickListener(this)
            ivShemaroMe.setOnClickListener(this)
            ivHboMax.setOnClickListener(this)
            ivDiscovery.setOnClickListener(this)
            ivHotStar.setOnClickListener(this)
            backButton.setOnClickListener(this)
            webView.webViewClient = WebViewClient()
            webView.settings.loadWithOverviewMode = true
            webView.settings.useWideViewPort = true
            webView.settings.domStorageEnabled = true
            webView.settings.javaScriptEnabled = true
            categoryRecycler.adapter = categoryAdaptor
            productsRecycler.adapter = movieAdaptor
            searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(text: String?): Boolean {
                    searchBar.clearFocus()
                    return true
                }

                override fun onQueryTextChange(text: String?): Boolean {
                    filteredCategoryList.clear()
                    filteredListMovieList.clear()
                    categoryAdaptor.setCategories(filteredCategoryList)
                    movieAdaptor.setMovies(filteredListMovieList)
                    for (item in categoryList) {
                        if(text?.let { item.category.lowercase().contains(it) } == true) {
                            filteredCategoryList.add(item)
                            categoryAdaptor.setCategories(filteredCategoryList)
                        }
                    }
                    for (item in getData) {
                        if(text?.let { item.name.lowercase().contains(it) } == true || text?.let { item.category.category.lowercase().contains(it) } == true) {
                            filteredListMovieList.add(item)
                            movieAdaptor.setMovies(filteredListMovieList)
                        }
                    }
                    return true
                }
            })
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress < MAX_PROGRESS && progressBar.visibility == ProgressBar.INVISIBLE) {
                   progressBar.visibility = ProgressBar.VISIBLE
                }
                if (newProgress == MAX_PROGRESS) {
                  progressBar.visibility = ProgressBar.INVISIBLE
                }
                progressBar.progress = newProgress
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            ivNetflix.id -> webView.loadUrl(Constant.NETFLIX)
            ivHotStar.id -> webView.loadUrl(Constant.HOTSTAR)
            ivDiscovery.id -> webView.loadUrl(Constant.DISCOVERY)
            ivShemaroMe.id -> webView.loadUrl(Constant.SHEMAROO)
            ivHboMax.id -> webView.loadUrl(Constant.HBOMAX)
        }
    }
}