package com.firecode.onlineshop.model

import com.google.gson.annotations.SerializedName

data class Credentials(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("password")
    var password: String = "",
    @SerializedName("password_confirmation")
    var password_confirmation: String = ""
)
