package com.firecode.onlineshop.model

import com.google.gson.annotations.SerializedName

data class Credentials2(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("password")
    var password: String = "",
    @SerializedName("device_name")
    var device_name: String = "Ipone"
)
