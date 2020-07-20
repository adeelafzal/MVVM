package com.adeelcheema.mvvm.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun imageLoader(imageView: ImageView,url:String){
    Glide
        .with(imageView)
        .load(url)
        .into(imageView)
}