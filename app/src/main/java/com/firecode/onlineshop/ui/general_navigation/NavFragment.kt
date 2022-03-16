package com.firecode.onlineshop.ui.general_navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentGeneralPoetsBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity

class NavFragment : BaseFragment<FragmentGeneralPoetsBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        NavigationUI.setupWithNavController(
            binding.communityBottomNavigationView,
            Navigation.findNavController(
                contextActivity,
                R.id.community_fragment_container_view
            )
        )
    }

     fun self() {
        findNavController().navigate(R.id.action_profileFragment_self)
    }

    override fun initViewBinding() = FragmentGeneralPoetsBinding.inflate(layoutInflater)
}
