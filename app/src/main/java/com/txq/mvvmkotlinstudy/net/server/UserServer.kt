package com.txq.mvvmkotlinstudy.net.server

import com.txq.mvvmkotlinstudy.bean.ReceivedEvent
import com.txq.mvvmkotlinstudy.bean.RepositoryInfo
import com.txq.mvvmkotlinstudy.bean.UserInfo
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by tang_xqing on 2020/1/3.
 */
interface UserService {

    @GET("user")
    fun fetchUserOwner(): Flowable<UserInfo>

    @GET("users/{username}/received_events?")
    fun queryReceivedEvents(@Path("username") username: String,
                            @Query("page") pageIndex: Int,
                            @Query("per_page") perPage: Int): Flowable<List<ReceivedEvent>>

    @GET("users/{username}/repos?")
    fun queryRepos(@Path("username") username: String,
                   @Query("page") pageIndex: Int,
                   @Query("per_page") perPage: Int,
                   @Query("sort") sort: String): Flowable<List<RepositoryInfo>>
}