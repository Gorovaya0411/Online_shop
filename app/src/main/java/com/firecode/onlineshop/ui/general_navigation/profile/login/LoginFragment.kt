package com.firecode.onlineshop.ui.general_navigation.profile.login

import android.os.Bundle
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.firecode.onlineshop.MyApplication
import com.firecode.onlineshop.R
import com.firecode.onlineshop.databinding.FragmentLoginBinding
import com.firecode.onlineshop.di.modul.ui.main.MainActivityModule
import com.firecode.onlineshop.ui.main.MainActivity
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter

class LoginFragment : MvpAppCompatFragment(), LoginView {

    private val contextActivity: MainActivity by lazy(LazyThreadSafetyMode.NONE) {
        (activity as MainActivity)
    }

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.loginLogIn.setOnClickListener {
            loginUser()
        }
    }

    @ProvidePresenter
    fun provideLandingActivityPresenter(): LoginPresenter {
        return MyApplication.appComponent.with(
            MainActivityModule()
        ).login
    }

    private fun loginUser() {
        with(binding) {
            val email: String = loginEmailEditText.text.toString()
            val password: String = loginPasswordEditText.text.toString()

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
                    loginPresenter.swipeRefresh(email, password)
                }
            }
        }
    }
}