package com.example.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.databinding.GridViewItemBinding
import com.example.countries.network.ContriesPhoto
import com.example.countries.network.Response

    class PhotoGridAdapter : ListAdapter<ContriesPhoto,PhotoGridAdapter.CountriesPhotoViewHolder>(DiffCallback){


    class CountriesPhotoViewHolder (private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(countriesPhotos: ContriesPhoto) {
        binding.country = countriesPhotos
        binding.executePendingBindings()
    }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):CountriesPhotoViewHolder {
    return CountriesPhotoViewHolder(GridViewItemBinding.inflate(
        LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(
        holder: CountriesPhotoViewHolder, position: Int) {
        val countriesPhotos = getItem(position)
        holder.bind(countriesPhotos)
    }


    companion object DiffCallback : DiffUtil.ItemCallback<ContriesPhoto>() {
        override fun areItemsTheSame(oldItem: ContriesPhoto, newItem: ContriesPhoto): Boolean {
                return oldItem.name == newItem.name
            }

        override fun areContentsTheSame(oldItem: ContriesPhoto, newItem: ContriesPhoto): Boolean {
            return oldItem.flag == newItem.flag
        }
    }

}