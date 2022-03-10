package com.firecode.onlineshop.ui.product

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.ItemProductBinding
import com.firecode.onlineshop.model.AnswerProducts
import com.squareup.picasso.Picasso

class ProductAdapter(private var callback: (AnswerProducts) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    private var dataTest = listOf<AnswerProducts>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<AnswerProducts>) {
        this.dataTest = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product,
                parent,
                false
            ), callback
        )
    }

    fun addData(listItems: List<AnswerProducts>) {
        val sizePast = this.dataTest.size
        this.dataTest = this.dataTest + listItems
        val sizeNew = this.dataTest.size
        notifyItemRangeChanged(sizePast, sizeNew)
    }

    override fun getItemCount(): Int = dataTest.count()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataTest[position])
    }

    class MyViewHolder(itemView: View, private var callback: (AnswerProducts) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(model: AnswerProducts) {

            val binding = ItemProductBinding.bind(itemView)

            binding.textView2.text = model.price.toString()
            binding.textView3.text = model.title

            Picasso.get()
                .load(model.img)
                .into(binding.imageView)

            itemView.setOnClickListener {
                callback.invoke(model)
            }
        }
    }
}