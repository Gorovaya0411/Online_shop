package com.firecode.onlineshop.ui.general_navigation.profile.register

import android.os.Bundle
import android.view.View
import com.firecode.onlineshop.databinding.FragmentRegisterBinding
import com.firecode.onlineshop.ui.base.BaseFragment

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViewBinding() = FragmentRegisterBinding.inflate(layoutInflater)
}