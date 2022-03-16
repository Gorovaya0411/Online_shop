package com.firecode.onlineshop.ui.general_navigation.profile.register

import com.firecode.onlineshop.domain.MainUseCaseImpl
import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    CommunityActivityPresente() {

    fun swipeRefresh(email: String, password: String) {
        charactersMainUseCase.setToken(email, password) { setCheckDetailedFragment(it) }
        if (getCheckDetailedFragment() != "null"){
            viewState.newactivitu()
        }

    }

    fun getCheckDetailedFragment(): String? {
        return charactersMainUseCase.checkDetailedFragment
    }

    private fun setCheckDetailedFragment(mark: String?) {
        charactersMainUseCase.checkDetailedFragment = mark
    }
}