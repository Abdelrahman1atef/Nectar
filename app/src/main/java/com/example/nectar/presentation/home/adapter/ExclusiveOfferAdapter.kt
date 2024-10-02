package com.example.nectar.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nectar.data.model.DataResponse
import com.example.nectar.databinding.CardItemBinding

class ExclusiveOfferAdapter :
    RecyclerView.Adapter<ExclusiveOfferAdapter.ExclusiveOfferViewHolder>() {
    private val hit = arrayListOf<DataResponse>()
    private lateinit var context: Context

    inner class ExclusiveOfferViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            Glide.with(context)
                .load(hit[position].image)
                .into(binding.ivProduct)
            binding.tvProductName.text=hit[position].title
            binding.tvProductPrice.text="$${hit[position].price}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExclusiveOfferViewHolder {
        context = parent.context
        val binding = CardItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ExclusiveOfferViewHolder(binding)
    }

    override fun getItemCount(): Int = hit.size

    override fun onBindViewHolder(holder: ExclusiveOfferViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setData(hits: List<DataResponse>) {
        hit.clear()
        hit.addAll(hits)
        notifyDataSetChanged()
    }
}