package com.firecode.onlineshop.ui.general_navigation.profile.login

import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface LoginView : MvpView

abstract class LoginActivityPresenter : MvpPresenter<LoginView>() {
    abstract fun getSaveToken(): String?
    abstract fun setSaveToken(mark: String?)
}