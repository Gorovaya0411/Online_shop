package com.firecode.onlineshop.ui.general_navigation.profile.register

import com.firecode.onlineshop.domain.MainUseCaseImpl
import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    RegisterActivityPresenter() {

    fun swipeRefresh(email: String, password: String) {
        charactersMainUseCase.setToken(email, password) { setSaveToken(it) }
        if (getSaveToken() != "null"){

        }
    }

    private fun getSaveToken(): String? {
        return charactersMainUseCase.saveToken
    }

    private fun setSaveToken(mark: String?) {
        charactersMainUseCase.saveToken = mark
    }
}