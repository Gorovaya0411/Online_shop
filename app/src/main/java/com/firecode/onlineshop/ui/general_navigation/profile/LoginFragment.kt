package com.firecode.onlineshop.ui.general_navigation.profile

import android.os.Bundle

import android.view.View
import com.firecode.onlineshop.databinding.FragmentLoginBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity

class LoginFragment : BaseFragment<FragmentLoginBinding>(){

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun initViewBinding() = FragmentLoginBinding.inflate(layoutInflater)
}