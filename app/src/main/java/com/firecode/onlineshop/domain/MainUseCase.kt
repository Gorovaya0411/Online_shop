package com.firecode.onlineshop.domain

import com.firecode.onlineshop.data.repository.CharactersMainRepository
import com.firecode.onlineshop.data.service.SessionStoreService
import com.firecode.onlineshop.model.DataCatalog
import com.firecode.onlineshop.model.DataProduct
import io.reactivex.Observable
import javax.inject.Inject

interface MainUseCase

class MainUseCaseImpl @Inject constructor(
    private val charactersMainRepository: CharactersMainRepository,
    private val sessionStoreService: SessionStoreService
) : MainUseCase {
    fun swipeRefreshCat(): Observable<DataCatalog> = charactersMainRepository.swipeRefreshCatalog()
    fun getToken(email: String, password: String, callback: (String) -> Unit) =
        charactersMainRepository.getToken(email, password, callback)

    fun getMoreItemsCat(): Observable<DataCatalog> = charactersMainRepository.getMoreItemsCatalog()
    fun swipeRefreshProd(): Observable<DataProduct> = charactersMainRepository.swipeRefreshProduct()
    fun getMoreItemsProd(): Observable<DataProduct> = charactersMainRepository.swipeRefreshProduct()
    fun setToken(email: String, password: String, callback: (String) -> Unit) =
        charactersMainRepository.setToken(email, password, callback)

    var saveToken: String?
        get() = sessionStoreService.saveToken
        set(value) {
            sessionStoreService.saveToken = value
        }
}