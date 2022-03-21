package com.firecode.onlineshop.ui.main

import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface MainActivityView : MvpView

abstract class MainActivityPresenter : MvpPresenter<MainActivityView>()