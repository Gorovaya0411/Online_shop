package com.firecode.onlineshop.ui.general_navigation.catalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.ItemCatalogBinding
import com.firecode.onlineshop.model.AnswerCategories

class CatalogAdapter(private var callback: (AnswerCategories) -> Unit) :
    RecyclerView.Adapter<CatalogAdapter.MyViewHolder>() {
    private var dataTest = listOf<AnswerCategories>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<AnswerCategories>) {
        this.dataTest = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_catalog,
                parent,
                false
            ), callback
        )
    }

    fun addData(listItems: List<AnswerCategories>) {
        val sizePast = this.dataTest.size
        this.dataTest = this.dataTest + listItems
        val sizeNew = this.dataTest.size
        notifyItemRangeChanged(sizePast, sizeNew)
    }

    override fun getItemCount(): Int = dataTest.count()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataTest[position])
    }

    class MyViewHolder(itemView: View, private var callback: (AnswerCategories) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(model: AnswerCategories) {
            val binding = ItemCatalogBinding.bind(itemView)

            binding.textView4.text = model.title
            binding.textView8.text = model.info
            itemView.setOnClickListener {
                callback.invoke(model)
            }
        }
    }
}