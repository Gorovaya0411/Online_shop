package com.firecode.onlineshop.ui.general_navigation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firecode.onlineshop.R
import com.firecode.onlineshop.ui.main.MainActivity

class RegisterFragment : Fragment() {
    // inflate the layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        inflater.inflate(R.layout.fragment_login, container, false)!!
}