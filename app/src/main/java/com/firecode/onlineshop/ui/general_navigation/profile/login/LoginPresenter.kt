package com.firecode.onlineshop.ui.general_navigation.profile.login


import android.util.Log
import com.firecode.onlineshop.domain.MainUseCaseImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    CommunityActivityPresenter() {

    fun swipeRefresh(email: String, password: String) {
        val disposable = charactersMainUseCase.getToken(email, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("", it.message)
            }, {
                setCheckDetailedFragment(it.message)
            })
    }

    override fun getCheckDetailedFragment(): String? {
        return charactersMainUseCase.checkDetailedFragment
    }

    override fun setCheckDetailedFragment(mark: String?) {
        charactersMainUseCase.checkDetailedFragment = mark
    }
}