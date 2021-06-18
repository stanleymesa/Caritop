package com.example.caritop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.zip.Inflater

class WishlistAdapter(val wishList: ArrayList<ModelLaptop>): RecyclerView.Adapter<WishlistAdapter.WishListHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class WishListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgLaptop: ImageView = itemView.findViewById(R.id.img_photo_wishlist)
        var merkLaptop: TextView = itemView.findViewById(R.id.tv_laptop_wishlist)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishListHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_wishlist, parent, false)
        return WishListHolder(view)
    }

    override fun getItemCount(): Int {
        return wishList.size
    }

    override fun onBindViewHolder(holder: WishListHolder, position: Int) {
        var laptop = wishList[position]
        Glide.with(holder.itemView)
            .load(laptop.photo)
            .into(holder.imgLaptop)

        holder.merkLaptop.text = laptop.name

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(wishList[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ModelLaptop)
    }
}