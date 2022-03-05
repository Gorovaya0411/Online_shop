package com.firecode.onlineshop.data.remote.interceptor

import com.firecode.onlineshop.data.service.InternetConnectionService
import com.firecode.onlineshop.extension.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class InternetInterceptor @Inject constructor(private var connectionService: InternetConnectionService) :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            if (!connectionService.isConnected())
                throw NoInternetException(
                    RuntimeException()
                )
            return chain.proceed(chain.request())
        } catch (e: IOException) {
            if (!connectionService.isConnected())
                throw NoInternetException(e)
            throw e
        }
    }
}