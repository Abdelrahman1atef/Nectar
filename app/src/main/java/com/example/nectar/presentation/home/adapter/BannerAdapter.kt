package com.example.nectar.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nectar.R
import com.bumptech.glide.Glide
import com.example.nectar.databinding.BannerItemBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class BannerAdapter : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    private val imageList = arrayListOf<String>()
    private lateinit var context: Context

    inner class BannerViewHolder(private val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            val imageUrl = imageList[position]
            Glide.with(context)
                .load(imageUrl)
                .transform(RoundedCornersTransformation(16, 0)) // 16 is the corner radius in pixels
                .into(binding.imageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        context = parent.context
        val binding = BannerItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setData(images: List<String>) {
        imageList.clear()
        imageList.addAll(images)
        notifyDataSetChanged()
    }
}



