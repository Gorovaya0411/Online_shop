package com.firecode.onlineshop.model

import java.io.Serializable

class AnswerProducts : Serializable {
    var id: Int = 0
    var title: String = ""
    var info: String = ""
    var img: String = ""
    var category: Category = Category()
    var price: Int = 0
}

