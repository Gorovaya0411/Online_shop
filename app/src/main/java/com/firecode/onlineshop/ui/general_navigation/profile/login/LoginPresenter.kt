package com.firecode.onlineshop.ui.general_navigation.profile.login


import android.util.Log
import com.firecode.onlineshop.data.service.OnlineShopApiService
import com.firecode.onlineshop.domain.MainUseCaseImpl
import com.firecode.onlineshop.model.Credentials
import com.firecode.onlineshop.model.GetTokenAnswer
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    CommunityActivityPresenter() {

    fun swipeRefresh(email: String, password: String) {
        charactersMainUseCase.getToken(email, password) { setCheckDetailedFragment(it) }
        if (getCheckDetailedFragment() != "null") {
            viewState.newactivitu()
        }
    }

    override fun getCheckDetailedFragment(): String? {
        return charactersMainUseCase.checkDetailedFragment
    }

    override fun setCheckDetailedFragment(mark: String?) {
        charactersMainUseCase.checkDetailedFragment = mark
    }
}