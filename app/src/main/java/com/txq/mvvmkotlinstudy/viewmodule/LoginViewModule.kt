package com.txq.mvvmkotlinstudy.viewmodule

import androidx.fragment.app.Fragment
import com.txq.base.mvvm.BaseViewModule
import com.txq.mvvmkotlinstudy.repository.LoginRepository

/**
 * Created by tang_xqing on 2020/1/3.
 */
class LoginViewModule(repository: LoginRepository) :
    BaseViewModule() {
    val mRepository: LoginRepository

    init {
        mRepository = repository
    }

    companion object{
        fun getInstance(fragment:Fragment,repository: LoginRepository):LoginViewModule{
            return LoginViewModule(repository)
        }
    }
}