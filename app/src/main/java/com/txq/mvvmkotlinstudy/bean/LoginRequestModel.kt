package com.txq.mvvmkotlinstudy.bean

import com.google.gson.annotations.SerializedName
import com.txq.base.BuildConfig

/**
 * Created by tang_xqing on 2020/1/3.
 */
data class LoginRequestModel(
    val scopes: List<String>,
    val note: String,
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String
) {
    companion object {
        fun generate(): LoginRequestModel {
            return LoginRequestModel(
                scopes = listOf("user", "repo", "gist", "notifications"),
                note = BuildConfig.APPLICATION_ID,
//                clientId = BuildConfig.CLIENT_ID,
//                clientSecret = BuildConfig.CLIENT_SECRET

                clientId = "CLIENT_ID",
                clientSecret = "BuildConfig.CLIENT_SECRET"
            )
        }
    }
}