package com.example.shopapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopapp.Model.CategoryModel
import com.example.shopapp.databinding.ViewholderCategoryBinding

class CategoryAdapter(val item:MutableList<CategoryModel>):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private lateinit var context: Context
    inner class ViewHolder(val binding: ViewholderCategoryBinding):
    RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        context=parent.context
        val binding=ViewholderCategoryBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)

    }



    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        val item=item[position]
        holder.binding.titleCate.text=item.title
        Glide.with(holder.itemView.context)
            .load(item.picUrl)
            .into(holder.binding.picCate)

    }

    override fun getItemCount(): Int =item.size

}