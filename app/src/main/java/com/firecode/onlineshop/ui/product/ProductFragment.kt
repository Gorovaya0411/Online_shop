package com.firecode.onlineshop.ui.product

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.firecode.onlineshop.MyApplication
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentProductBinding
import com.firecode.onlineshop.di.modul.ui.main.MainActivityModule
import com.firecode.onlineshop.extension.PaginationScrollListener
import com.firecode.onlineshop.model.AnswerProducts
import com.firecode.onlineshop.ui.main.MainActivity
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import java.util.*

class ProductFragment : MvpAppCompatFragment(), ProductView {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }
    private lateinit var random: Random
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val myAdapter =
        ProductAdapter{openingNewActivity(it)}

    private lateinit var binding: FragmentProductBinding

    @InjectPresenter
    lateinit var mainPresenter: ProductPresenter

    @ProvidePresenter
    fun provideLandingActivityPresenter(): ProductPresenter {
        return MyApplication.appComponent.with(
            MainActivityModule()
        ).product
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductBinding.bind(view)

        workWithAdapter()
        visibilityProgressBar(false)
        mainPresenter.swipeRefresh(arguments?.getString("catalog")!!)

        random = Random()
        handler = Handler()
        binding.swipeRefreshLayout.setOnRefreshListener {

            runnable = Runnable {
                mainPresenter.swipeRefresh(arguments?.getString("catalog")!!)
                mainPresenter.getMoreItems(arguments?.getString("catalog")!!)
                binding.swipeRefreshLayout.isRefreshing = false
            }

            handler.postDelayed(
                runnable, 3000.toLong()
            )
        }

        binding.recyclerView.addOnScrollListener(
            PaginationScrollListener(
                { mainPresenter.getMoreItems(arguments?.getString("catalog")!!) },
                20
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    private fun workWithAdapter() {
        binding.recyclerView.layoutManager = GridLayoutManager(contextActivity, 2)
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

    override fun populateData(model: List<AnswerProducts>) {
        if (model.isEmpty()){
            binding.productEmptyTxt.text = "К сожалению в данный момент дананя продукция недоступна"
        }else{
            myAdapter.setData(model)
        }
    }

    private fun openingNewActivity(model: AnswerProducts) {
        val bundle = Bundle()
        with(bundle){
            putString("title", model.title)
            putString("img", model.img)
            putString("info", model.info)
            putInt("price", model.price)
        }
        findNavController().navigate(R.id.detailedFragment, bundle)
    }

    override fun addData(model: List<AnswerProducts>) {
        myAdapter.addData(model)
    }
}