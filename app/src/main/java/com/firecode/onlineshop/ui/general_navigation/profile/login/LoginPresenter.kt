package com.firecode.onlineshop.ui.general_navigation.profile.login


import com.firecode.onlineshop.domain.MainUseCaseImpl
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    LoginActivityPresenter() {

    fun swipeRefresh(email: String, password: String) {
        charactersMainUseCase.getToken(email, password) { setSaveToken(it) }
        if (getSaveToken() != "null") {

        }
    }

    override fun getSaveToken(): String? {
        return charactersMainUseCase.saveToken
    }

    override fun setSaveToken(mark: String?) {
        charactersMainUseCase.saveToken = mark
    }
}