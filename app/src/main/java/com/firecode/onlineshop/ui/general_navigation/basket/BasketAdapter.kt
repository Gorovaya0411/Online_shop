package com.firecode.onlineshop.ui.general_navigation.basket

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firecode.onlineshop.R
import com.firecode.onlineshop.model.AnswerProducts


class BasketAdapter :
    RecyclerView.Adapter<BasketAdapter.MyViewHolder>() {
    var dataTest = mutableListOf<AnswerProducts?>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: MutableList<AnswerProducts?>) {
        this.dataTest = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_basket,
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



        fun bind(model: AnswerProducts) {

        }
    }
}