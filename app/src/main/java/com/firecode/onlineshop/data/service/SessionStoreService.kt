package com.firecode.onlineshop.data.service

import com.firecode.onlineshop.db.SessionStore
import javax.inject.Inject

interface SessionStoreService {
    var saveToken: String?
}

class SessionStoreServiceImpl @Inject constructor(private val sessionStore: SessionStore) :
    SessionStoreService {

    override var saveToken: String?
        get() = sessionStore.saveToken
        set(value) {
            sessionStore.saveToken = value
        }
}