package com.txq.mvvmkotlinstudy.repository

import com.txq.base.mvvm.BaseRepository
import com.txq.mvvmkotlinstudy.bean.LoginRequestModel
import com.txq.mvvmkotlinstudy.net.server.ServiceManager

/**
 * Created by tang_xqing on 2020/1/3.
 */
class LoginRepository(service :ServiceManager) :BaseRepository() {
    // 进行网络请求
    val mService:ServiceManager
    init {
        mService = service
    }

    fun authorizations(){
        mService.loginService.authorizations(LoginRequestModel.generate())
    }
}