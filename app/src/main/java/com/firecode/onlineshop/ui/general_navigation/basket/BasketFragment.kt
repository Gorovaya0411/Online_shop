package com.firecode.onlineshop.ui.general_navigation.basket

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentBasketBinding
import com.firecode.onlineshop.databinding.FragmentGeneralPoetsBinding
import com.firecode.onlineshop.model.PoemAnswer
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.general_navigation.catalog.CatalogAdapter
import com.firecode.onlineshop.ui.main.MainActivity

class BasketFragment : BaseFragment<FragmentBasketBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }
    private val myAdapter =
        BasketAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listPoetRecyclerView.layoutManager =
            LinearLayoutManager(contextActivity, RecyclerView.VERTICAL, false)
        binding.listPoetRecyclerView.adapter = myAdapter

        val poem: PoemAnswer? = PoemAnswer()
        val listPoemPoet: MutableList<PoemAnswer?> = mutableListOf()
        listPoemPoet.add(poem)

        myAdapter.setData(listPoemPoet)
    }

    override fun onStart() {
        super.onStart()

    }

    override fun initViewBinding() = FragmentBasketBinding.inflate(layoutInflater)
}
