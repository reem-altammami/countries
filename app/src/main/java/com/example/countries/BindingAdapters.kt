package com.example.countries

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.countries.network.ContriesPhoto
import com.example.countries.network.Response

class BindingAdapters {


    @BindingAdapter("imageUrl")
    fun ImageView.bindImage( imgUrl: String?) {
        imgUrl?.let {
            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            this.load(imgUri){
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }
        }
    }

    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView,
                         data: List<ContriesPhoto>?) {
        val adapter = recyclerView.adapter as PhotoGridAdapter
        adapter.submitList(data)

    }
}