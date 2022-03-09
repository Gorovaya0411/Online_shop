package com.firecode.onlineshop.ui.general_navigation.catalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firecode.onlineshop.R
import com.firecode.onlineshop.model.PoemAnswer

class CatalogAdapter :
    RecyclerView.Adapter<CatalogAdapter.MyViewHolder>() {
    var dataTest = mutableListOf<PoemAnswer?>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: MutableList<PoemAnswer?>) {
        this.dataTest = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_catalog,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = dataTest.count()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        dataTest[position]?.let { holder.bind(it) }
    }


    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {



        fun bind(model: PoemAnswer) {

        }
    }
}