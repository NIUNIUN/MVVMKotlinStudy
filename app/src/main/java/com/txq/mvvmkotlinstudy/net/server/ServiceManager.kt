package com.txq.mvvmkotlinstudy.net.server

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import retrofit2.Retrofit

/**
 * Created by tang_xqing on 2020/1/3.
 */

const val SERVICE_MODULE_TAG = "service_tag"

val serviceModule = Kodein.Module(SERVICE_MODULE_TAG) {
    bind<UserService>() with provider {
        instance<Retrofit>().create(UserService::class.java)
    }

    bind<LoginService>() with provider {
        instance<Retrofit>().create(LoginService::class.java)
    }

    bind<ServiceManager>() with provider {
        ServiceManager(instance(), instance())
    }
}

data class ServiceManager(val userService: UserService, val loginService: LoginService)