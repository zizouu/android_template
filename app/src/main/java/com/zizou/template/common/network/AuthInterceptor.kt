package com.zizou.template.common.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private var token: String?) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        with(chain) {
            val newRequest = request().newBuilder().run {
                addHeader("accessToken", "$token")
                build()
            }
            proceed(newRequest)
        }

    fun updateToken(updateToken: String) {
        token = updateToken
    }

}