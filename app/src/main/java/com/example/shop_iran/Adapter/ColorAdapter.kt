package com.example.shop_iran.Adapter

import android.content.Context
import android.transition.Slide
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shop_iran.R
import com.example.shop_iran.databinding.ViewholderColorBinding

class ColorAdapter(val items:MutableList<String>):RecyclerView.Adapter<ColorAdapter.Viewholder>() {

    private var selectedPosition=-1
    private var lastSelecionPosition=-1
    private lateinit var context: Context

    inner class Viewholder (val binding: ViewholderColorBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorAdapter.Viewholder {
       context=parent.context
        val binding=ViewholderColorBinding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: ColorAdapter.Viewholder, position: Int) {
       Glide.with(holder.itemView.context)
           .load(items[position])
           .into(holder.binding.pic)

        holder.binding.root.setOnClickListener(){
            lastSelecionPosition=selectedPosition
            selectedPosition=position
            notifyItemChanged(lastSelecionPosition)
            notifyItemChanged(selectedPosition)
        }
        if (selectedPosition==position){
            holder.binding.colorLayout.setBackgroundResource(R.drawable.white_bg_selected)
        }else{
            holder.binding.colorLayout.setBackgroundResource(R.drawable.white_bg)
        }
    }

    override fun getItemCount(): Int =items.size
}