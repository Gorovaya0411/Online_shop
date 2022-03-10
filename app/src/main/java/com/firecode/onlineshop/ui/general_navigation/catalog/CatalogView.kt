package com.firecode.onlineshop.ui.general_navigation.catalog

import com.firecode.onlineshop.model.AnswerCategories
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndStrategy::class)
interface CatalogView : MvpView {
    fun populateData(model: List<AnswerCategories>)
    fun visibilityProgressBar(isVisible: Boolean)
    fun addData(model: List<AnswerCategories>)
}