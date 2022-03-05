package com.firecode.onlineshop.ui.general_navigation.profile

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.view.PagerAdapter
import android.view.View
import com.firecode.onlineshop.databinding.FragmentProfileBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contextActivity.setSupportActionBar(binding.materialToolbar)
        val adapter:PagerAdapter = PagerAdapter(contextActivity.supportFragmentManager)

        adapter.addFragment(LoginFragment(), "GeeksForGeeks")
        adapter.addFragment(RegisterFragment(), "Code Chef")

        binding.viewPager.adapter = adapter

        binding.tabs.setupWithViewPager(binding.viewPager)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun initViewBinding() = FragmentProfileBinding.inflate(layoutInflater)
}
