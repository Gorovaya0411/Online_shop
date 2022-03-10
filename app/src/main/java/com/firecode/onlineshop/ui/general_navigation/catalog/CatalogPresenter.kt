package com.firecode.onlineshop.ui.general_navigation.catalog


import com.firecode.onlineshop.domain.MainUseCaseImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class CatalogPresenter @Inject constructor(private val charactersMainUseCase: MainUseCaseImpl) :
    MvpPresenter<CatalogView>() {

    private var isRequest: Boolean = false

    fun swipeRefresh(): Boolean {

        val disposable = charactersMainUseCase.swipeRefreshCat()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.populateData(it.data)
                viewState.visibilityProgressBar(false)
            }, {

            })
        return true
    }

    fun getMoreItems() {
        if (!isRequest) {
            isRequest = true
            viewState.visibilityProgressBar(true)
            val disposable = charactersMainUseCase.getMoreItemsCat()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.addData(it.data)
                    isRequest = false
                    viewState.visibilityProgressBar(false)

                }, {
                    viewState.visibilityProgressBar(false)
                })
        }
    }
}