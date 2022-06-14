package com.example.androidoverview

import android.widget.ImageView
import com.bumptech.glide.Glide

fun loadImage(url: String?, uploadImage: ImageView) {
    Glide.with(uploadImage).load(url).into(uploadImage)
}

fun loadCircleImage(url: String?, uploadImage: ImageView) {
    Glide.with(uploadImage).load(url).circleCrop().into(uploadImage)
}