package com.txq.mvvmkotlinstudy.module

import com.txq.mvvmkotlinstudy.BuildConfig
import com.txq.mvvmkotlinstudy.net.server.UserServer
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by tang_xqing on 2020/1/3.
 */

const val BASE_URL = "https://api.github.com/"
const val INTERCEPTOR_HTTP_LOG = "INTERCEPTOR_HTTP_LOG"
const val HTTP_MODULE_TAG = "http_module_tag"

const val READ_TIMEOUT: Long = 5000
const val CONNECT_TIMEOUT: Long = 10000

val httpModule = Kodein.Module(HTTP_MODULE_TAG) {
    bind<Retrofit.Builder>() with provider { Retrofit.Builder() }
    bind<OkHttpClient.Builder>() with provider { OkHttpClient.Builder() }

    bind<Interceptor>(INTERCEPTOR_HTTP_LOG) with provider {
        HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    bind<OkHttpClient>() with provider {
        instance<OkHttpClient.Builder>()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(instance(INTERCEPTOR_HTTP_LOG))
            .build()
    }

    bind<Retrofit>() with singleton {
        instance<Retrofit.Builder>()
            .baseUrl(BASE_URL)
            .client(instance())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    bind<UserServer>() with provider {
        instance<Retrofit>().create(UserServer::class.java)
    }
}