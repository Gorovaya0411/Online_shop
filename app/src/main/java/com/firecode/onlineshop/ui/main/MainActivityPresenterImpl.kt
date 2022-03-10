package com.firecode.onlineshop.ui.main

import com.firecode.onlineshop.domain.MainUseCase
import javax.inject.Inject


class MainActivityPresenterImpl @Inject constructor(
    private val mainUseCase: MainUseCase
) : MainActivityPresenter()