package com.firecode.onlineshop.ui.detailedFragment

import android.os.Bundle
import android.view.View
import com.firecode.onlineshop.databinding.FragmentDetailedProductBinding
import com.firecode.onlineshop.databinding.FragmentLoginBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity
import com.squareup.picasso.Picasso


class DetailedFragment : BaseFragment<FragmentDetailedProductBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewName.text = arguments?.getString("title")!!
        binding.textViewSpecies.text = arguments?.getInt("price")!!.toString()
        binding.textView.text = "${arguments?.getString("info")!!}руб"

        Picasso.get()
            .load(arguments?.getString("img")!!)
            .into(binding.imageViewCharacter)

    }

    override fun initViewBinding() = FragmentDetailedProductBinding.inflate(layoutInflater)
}