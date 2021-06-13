package com.example.caritop

import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListLaptopAdapter(val listLaptop: ArrayList<ModelLaptop>): RecyclerView.Adapter<ListLaptopAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgLaptop: ImageView = itemView.findViewById(R.id.img_photo)
        var tvNamaLaptop: TextView = itemView.findViewById(R.id.tv_nama_laptop)
        var tvInfoLaptop: TextView = itemView.findViewById(R.id.tv_info_laptop)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_laptop, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listLaptop.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val laptop: ModelLaptop = listLaptop[position]
        Glide.with(holder.itemView.context)
            .load(laptop.photo)
            .into(holder.imgLaptop)

        holder.tvNamaLaptop.text = laptop.name
        holder.tvInfoLaptop.text = laptop.desc

        holder.itemView.setOnClickListener(){
            onItemClickCallback.onItemClicked(listLaptop[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ModelLaptop)

    }
}