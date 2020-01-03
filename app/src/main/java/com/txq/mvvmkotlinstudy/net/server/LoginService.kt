package com.txq.mvvmkotlinstudy.net.server

import com.txq.mvvmkotlinstudy.bean.LoginRequestModel
import com.txq.mvvmkotlinstudy.bean.UserAccessToken
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by tang_xqing on 2020/1/3.
 */
interface LoginService{
    @POST("authorizations")
    @Headers("Accept: application/json")
    fun authorizations(
        @Body authRequestModel: LoginRequestModel
    ): Flowable<UserAccessToken>
}