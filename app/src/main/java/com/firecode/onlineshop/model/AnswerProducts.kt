package com.firecode.onlineshop.model

import java.io.Serializable

data class AnswerProducts(
    val id: Int,
    val title: String,
    val info: String,
    val img: String,
    val category: Category,
    val price: Int
) : Serializable

