package com.firecode.onlineshop.ui.detailedFragment

import android.os.Bundle
import android.view.View
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentDetailedProductBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity
import com.squareup.picasso.Picasso


class DetailedFragment : BaseFragment<FragmentDetailedProductBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }
    var num = 0

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
        binding.textViewSpecies.text = "$result руб."
        binding.textView.text = arguments?.getString("info")!!

        Picasso.get()
            .load(arguments?.getString("img")!!)
            .into(binding.imageViewCharacter)

        binding.bottom.setOnClickListener {
            num ++
            binding.bottom.setBackgroundResource(R.drawable.ic_group_1__2_)
            binding.txt.text = "в корзине + $num"
        }

    }

    override fun initViewBinding() = FragmentDetailedProductBinding.inflate(layoutInflater)
}