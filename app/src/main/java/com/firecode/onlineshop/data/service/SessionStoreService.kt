package com.firecode.onlineshop.data.service

import com.firecode.onlineshop.db.SessionStore
import javax.inject.Inject

interface SessionStoreService {
    var checkDetailedFragment: String?
}

class SessionStoreServiceImpl @Inject constructor(private val sessionStore: SessionStore) :
    SessionStoreService {

    override var checkDetailedFragment: String?
        get() = sessionStore.checkDetailedFragment
        set(value) {
            sessionStore.checkDetailedFragment = value
        }
}