package com.example.shopapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.shopapp.Activity.DetailActivity
import com.example.shopapp.Model.ItemsModel
import com.example.shopapp.databinding.ViewholderBestSellerBinding

class BestSellerAdapter(private val items: List<ItemsModel>) : RecyclerView.Adapter<BestSellerAdapter.ViewHolder>() {

    private var context: Context? = null

    class ViewHolder(val binding: ViewholderBestSellerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ViewholderBestSellerBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.apply {
            titleTxt.text = item.title
            priceTxt.text = "$${item.price}"
            ratingTxt.text = item.rating.toString()

            val requestOptions = RequestOptions().transform(CenterCrop())
            Glide.with(holder.itemView.context)
                .load(item.picUrl[0])
                .apply(requestOptions)
                .into(picBestSeller)

            holder.itemView.setOnClickListener {
                val intent= Intent(holder.itemView.context,DetailActivity::class.java)
                intent.putExtra("object",items[position])
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
