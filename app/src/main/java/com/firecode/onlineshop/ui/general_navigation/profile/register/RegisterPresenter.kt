package com.firecode.onlineshop.ui.general_navigation.profile.register


import android.util.Log
import com.firecode.onlineshop.domain.MainUseCaseImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    RegisterView {

    fun swipeRefresh(email: String, password: String) {
        val disposable = charactersMainUseCase.setToken(email, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, {
               Log.e("", "Все круто")
            })
    }
}