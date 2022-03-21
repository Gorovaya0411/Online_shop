package com.firecode.onlineshop.ui.main

import com.firecode.onlineshop.domain.MainUseCaseImpl
import javax.inject.Inject


class MainActivityPresenterImpl @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl
) : MainActivityPresenter(){
    fun getCheckDetailedFragment(): String? {
        return charactersMainUseCase.saveToken
    }
}