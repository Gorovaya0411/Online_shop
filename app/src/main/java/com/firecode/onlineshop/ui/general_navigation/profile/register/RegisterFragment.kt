package com.firecode.onlineshop.ui.general_navigation.profile.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.firecode.onlineshop.MyApplication
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentLoginBinding
import com.firecode.onlineshop.databinding.FragmentRegisterBinding
import com.firecode.onlineshop.di.modul.ui.main.MainActivityModule
import com.firecode.onlineshop.ui.base.BaseFragment
import com.firecode.onlineshop.ui.general_navigation.profile.login.LoginPresenter
import com.firecode.onlineshop.ui.general_navigation.profile.login.LoginView
import com.firecode.onlineshop.ui.main.MainActivity
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class RegisterFragment : MvpAppCompatFragment(), RegisterView {
    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    @InjectPresenter
    lateinit var maPresenter: RegisterPresenter

    @ProvidePresenter
    fun provideLandingActivityPresenter(): RegisterPresenter {
        return MyApplication.appComponent.with(
            MainActivityModule()
        ).register
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        binding.loginLogIn.setOnClickListener {
           loginUser()
        }
    }
    private lateinit var binding: FragmentRegisterBinding

    private fun loginUser() {
        with(binding) {
            val email: String = registerEmailEditText.text.toString()
            val password: String = registerPasswordEditText.text.toString()

            when {
                email == "" -> Toast.makeText(
                    contextActivity,
                    "Введите E-mail",
                    Toast.LENGTH_LONG
                )
                    .show()
                password == "" -> Toast.makeText(
                    contextActivity,
                    "Введите пароль",
                    Toast.LENGTH_LONG
                ).show()
                else -> {
                    maPresenter.swipeRefresh(email, password)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }
}