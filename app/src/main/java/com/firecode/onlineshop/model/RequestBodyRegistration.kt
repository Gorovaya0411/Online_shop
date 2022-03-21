package com.firecode.onlineshop.model

import com.google.gson.annotations.SerializedName
import com.squareup.okhttp.RequestBody

data class RequestBodyRegistration(
    @SerializedName("email")
    var email: RequestBody,
    @SerializedName("password")
    var password: RequestBody,
    @SerializedName("password_confirmation")
    var password_confirmation: RequestBody
)
