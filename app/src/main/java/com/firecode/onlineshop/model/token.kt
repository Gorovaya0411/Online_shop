package com.firecode.onlineshop.model

import com.google.gson.annotations.SerializedName
import java.security.MessageDigest

data class token(
    val token:String,
    val message:String
)
