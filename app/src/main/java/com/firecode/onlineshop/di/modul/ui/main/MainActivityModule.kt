package com.firecode.onlineshop.di.modul.ui.main

import com.firecode.onlineshop.domain.MainUseCase
import com.firecode.onlineshop.ui.main.MainActivityPresenter
import com.firecode.onlineshop.ui.main.MainActivityPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    @MainActivityScope
    fun provideMainActivityPresenter(mainUseCase: MainUseCase): MainActivityPresenter {
        return MainActivityPresenterImpl(mainUseCase)
    }
}