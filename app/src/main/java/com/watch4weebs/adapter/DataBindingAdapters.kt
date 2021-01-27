package com.watch4weebs.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingAdapters {

    @BindingAdapter("android:src")
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource)
    }
}