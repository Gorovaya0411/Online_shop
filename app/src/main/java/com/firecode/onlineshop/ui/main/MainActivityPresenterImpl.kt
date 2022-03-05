package com.firecode.onlineshop.ui.main

import com.firecode.onlineshop.domain.MainUseCase
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainActivityPresenterImpl @Inject constructor(
    private val mainUseCase: MainUseCase

) : MainActivityPresenter() {
}