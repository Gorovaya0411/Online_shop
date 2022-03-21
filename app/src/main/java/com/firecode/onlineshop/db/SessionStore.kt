package com.firecode.onlineshop.db

import android.content.SharedPreferences

class SessionStore(private val sharedPreferences: SharedPreferences) {

    var saveToken: String?
        get() = sharedPreferences.getString(KEY_SAVE_TOKEN, "")
        set(value) {
            sharedPreferences.edit().putString(KEY_SAVE_TOKEN, value).apply()
        }

    companion object {
        const val KEY_SAVE_TOKEN = "check_save_token"
    }
}
