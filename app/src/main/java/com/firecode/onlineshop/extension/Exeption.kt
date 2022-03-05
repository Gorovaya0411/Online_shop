package com.firecode.onlineshop.extension

import java.io.IOException

class NoInternetException(cause: Throwable) : IOException(cause)

class ClientException(cause: String) : Exception(cause)