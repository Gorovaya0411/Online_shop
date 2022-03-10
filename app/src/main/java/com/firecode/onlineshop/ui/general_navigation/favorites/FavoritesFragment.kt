package com.firecode.onlineshop.ui.general_navigation.favorites

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firecode.onlineshop.databinding.FragmentFavoritesBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    private val myAdapter =
        FavoritesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(contextActivity, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = myAdapter

    }

    override fun onStart() {
        super.onStart()

    }

    override fun initViewBinding() = FragmentFavoritesBinding.inflate(layoutInflater)
}
