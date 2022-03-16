package com.firecode.onlineshop.ui.general_navigation.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentProfileBinding
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileProfileTxt.text = contextActivity.presenter.getCheckDetailedFragment()
        check()
    }

    private fun check() {
        if (contextActivity.presenter.getCheckDetailedFragment() != "null") {
            binding.textView.visibility = TextView.INVISIBLE
            binding.profileProfileTxt.text = contextActivity.presenter.getCheckDetailedFragment()
            binding.generalPoetsBottomNavigationView.visibility = BottomNavigationItemView.INVISIBLE
        }
    }

    override fun onStart() {
        super.onStart()
        NavigationUI.setupWithNavController(
            binding.generalPoetsBottomNavigationView,
            Navigation.findNavController(
                contextActivity,
                R.id.profile_fragment_container_view
            )
        )
    }

    override fun initViewBinding() = FragmentProfileBinding.inflate(layoutInflater)
}
