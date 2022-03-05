package com.firecode.onlineshop.ui.general_navigation.basket

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentBasketBinding
import com.firecode.onlineshop.databinding.FragmentGeneralPoetsBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity

class BasketFragment : BaseFragment<FragmentBasketBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

    }

    override fun initViewBinding() = FragmentBasketBinding.inflate(layoutInflater)
}
