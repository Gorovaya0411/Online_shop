package com.firecode.onlineshop.domain

import com.firecode.onlineshop.data.repository.CharactersMainRepository
import com.firecode.onlineshop.data.service.SessionStoreService
import com.firecode.onlineshop.model.DataCat
import com.firecode.onlineshop.model.DataProd
import com.firecode.onlineshop.model.GetTokenAnswer
import io.reactivex.Observable
import javax.inject.Inject

interface MainUseCase

class MainUseCaseImpl @Inject constructor(
    private val charactersMainRepository: CharactersMainRepository,
    private val sessionStoreService: SessionStoreService
) : MainUseCase {
    fun swipeRefreshCat(): Observable<DataCat> = charactersMainRepository.swipeRefreshCat()
    fun getToken(email: String, password: String, device_name:String): GetTokenAnswer =
        charactersMainRepository.getToken(email, password,device_name)

    fun getMoreItemsCat(): Observable<DataCat> = charactersMainRepository.getMoreItemsCat()
    fun swipeRefreshProd(): Observable<DataProd> = charactersMainRepository.swipeRefreshProd()
    fun getMoreItemsProd(): Observable<DataProd> = charactersMainRepository.swipeRefreshProd()
    fun setToken(email: String, password: String) = charactersMainRepository.setToken(email, password)

    var checkDetailedFragment: String?
        get() = sessionStoreService.checkDetailedFragment
        set(value) {
            sessionStoreService.checkDetailedFragment = value
        }
}