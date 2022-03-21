package com.firecode.onlineshop.ui.detailedFragment

import android.os.Bundle
import android.view.View
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentDetailedProductBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.squareup.picasso.Picasso


class DetailedFragment : BaseFragment<FragmentDetailedProductBinding>() {

    var numberItemsInBasket = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayPrice = mutableListOf<Char>()
        arguments?.getInt("price")!!.toString().forEach {
            arrayPrice.add(it)
        }
        arrayPrice.add(arrayPrice.size - 3, ' ')
        var result = ""
        arrayPrice.forEach {
            result = "$result$it"
        }

        binding.textViewName.text = arguments?.getString("title")!!
        binding.textViewSpecies.text = getString(R.string.species, result)
        binding.textView.text = arguments?.getString("info")!!

        Picasso.get()
            .load(arguments?.getString("img")!!+".webp")
            .into(binding.imageViewCharacter)

        binding.bottom.setOnClickListener {
            numberItemsInBasket++
            binding.bottom.setBackgroundResource(R.drawable.ic_in_busket_add)
            binding.txt.text = getString(R.string.txt_basket, numberItemsInBasket)
        }

    }

    override fun initViewBinding() = FragmentDetailedProductBinding.inflate(layoutInflater)
}