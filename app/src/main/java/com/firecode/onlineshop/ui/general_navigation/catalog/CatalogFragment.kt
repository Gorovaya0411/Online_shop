package com.firecode.onlineshop.ui.general_navigation.catalog

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.firecode.onlineshop.MyApplication
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentCatalogBinding
import com.firecode.onlineshop.di.modul.ui.main.MainActivityModule
import com.firecode.onlineshop.extension.PaginationScrollListener
import com.firecode.onlineshop.model.AnswerCategories
import com.firecode.onlineshop.ui.main.MainActivity
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.util.*

class CatalogFragment : MvpAppCompatFragment(), CatalogView {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }
    private lateinit var random: Random
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val myAdapter =
        CatalogAdapter { openingNewActivity(it) }

    private lateinit var binding: FragmentCatalogBinding

    @InjectPresenter
    lateinit var mainPresenter: CatalogPresenter

    @ProvidePresenter
    fun provideLandingActivityPresenter(): CatalogPresenter {
        return MyApplication.appComponent.with(
            MainActivityModule()
        ).catalog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatalogBinding.bind(view)

        workWithAdapter()
        visibilityProgressBar(false)
        mainPresenter.swipeRefresh()

        random = Random()
        handler = Handler()
        binding.swipeRefreshLayout.setOnRefreshListener {

            runnable = Runnable {
                mainPresenter.swipeRefresh()
                mainPresenter.getMoreItems()
                binding.swipeRefreshLayout.isRefreshing = false
            }

            handler.postDelayed(
                runnable, 3000.toLong()
            )
        }

        binding.recyclerView.addOnScrollListener(
            PaginationScrollListener(
                { mainPresenter.getMoreItems() },
                20
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    private fun workWithAdapter() {
        binding.recyclerView.layoutManager = LinearLayoutManager(contextActivity)
        binding.recyclerView.adapter = myAdapter
    }

    override fun visibilityProgressBar(isVisible: Boolean) {
        when (isVisible) {
            true -> {
                binding.progressBar.visibility = ProgressBar.VISIBLE
            }
            false -> {
                binding.progressBar.visibility = ProgressBar.INVISIBLE
            }
        }
    }

    override fun populateData(model: List<AnswerCategories>) {
        myAdapter.setData(model)
    }

    private fun openingNewActivity(model: AnswerCategories) {
        val bundle = Bundle()
        with(bundle) {
            putString("catalog", model.title)
        }
        findNavController().navigate(R.id.productFragment, bundle)
    }

    override fun addData(model: List<AnswerCategories>) {
        myAdapter.addData(model)
    }
}
