package com.firecode.onlineshop.db

import android.content.SharedPreferences

class SessionStore(private val sharedPreferences: SharedPreferences) {

    var checkDetailedFragment: String?
        get() = sharedPreferences.getString(KEY_CHECK_DETAILED_FRAGMENT, "")
        set(value) {
            sharedPreferences.edit().putString(KEY_CHECK_DETAILED_FRAGMENT, value).apply()
        }

    companion object {
        const val KEY_CHECK_DETAILED_FRAGMENT = "check_detailed_fragment"
    }
}
