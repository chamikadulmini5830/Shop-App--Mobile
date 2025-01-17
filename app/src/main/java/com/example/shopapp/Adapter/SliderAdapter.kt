package com.example.shopapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.example.shopapp.Model.SliderModel
import com.example.shopapp.R

class SliderAdapter(
    private var sliderItems: List<SliderModel>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private lateinit var context: Context

    class SliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.ImageSlide)

        fun setImage(slideItem: SliderModel, context: Context) {
            val requestOptions = RequestOptions().transform(CenterInside())

            Glide.with(context)
                .load(slideItem.url)
                .apply(requestOptions)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderAdapter.SliderViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.slider_image_container, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderAdapter.SliderViewHolder, position: Int) {
        holder.setImage(sliderItems[position], context)

        // Logic to implement infinite scroll behavior
        if (position == sliderItems.size - 1) {
            viewPager2.post {
                viewPager2.currentItem = 0 // Reset to the first item
            }
        }
    }

    override fun getItemCount(): Int = sliderItems.size
}
