package com.example.countries

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.example.countries.network.ContriesPhoto
import com.example.countries.network.Response



//    @BindingAdapter("imageUrl")
//    fun ImageView.bindImage( imgUrl: String?) {
//        imgUrl?.let {
//            val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//            this.load(imgUri){
//                placeholder(R.drawable.loading_animation)
//                error(R.drawable.ic_broken_image)
//            }
//        }
//    }
@BindingAdapter("imageUrl")
fun ImageView.loadSvg(imageUri: String?) {
    imageUri?.let{
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
            .build()

        this.load(uri = imageUri, imageLoader = imageLoader) {
            crossfade(true)
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)    }
    }

}

    @BindingAdapter("listData")
    fun RecyclerView.bindRecyclerView(data: List<ContriesPhoto>?) {
        Log.e("TAG", "getCountriesPhotos: ${data?.size}", )
        Log.e("TAG", "getCountriesPhotos:  123123")
        val adapter = this.adapter as PhotoGridAdapter
        adapter.submitList(data)
    }
