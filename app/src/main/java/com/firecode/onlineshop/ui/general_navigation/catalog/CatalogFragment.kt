package com.firecode.onlineshop.ui.general_navigation.catalog

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firecode.onlineshop.databinding.FragmentCatalogBinding
import com.firecode.onlineshop.model.PoemAnswer
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity

class CatalogFragment : BaseFragment<FragmentCatalogBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }
    private val myAdapter =
        CatalogAdapter()

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

    override fun initViewBinding() = FragmentCatalogBinding.inflate(layoutInflater)
}
