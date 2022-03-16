package com.firecode.onlineshop.ui.main

import android.widget.TextView
import com.firecode.onlineshop.domain.MainUseCaseImpl
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import javax.inject.Inject


class MainActivityPresenterImpl @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl
) : MainActivityPresenter(){
    fun getCheckDetailedFragment(): String? {
        return charactersMainUseCase.checkDetailedFragment
    }

}