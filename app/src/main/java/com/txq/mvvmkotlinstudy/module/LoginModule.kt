package com.txq.mvvmkotlinstudy.module

import androidx.fragment.app.Fragment
import com.txq.mvvmkotlinstudy.repository.LoginRepository
import com.txq.mvvmkotlinstudy.viewmodule.LoginViewModule
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.*

/**
 * Created by tang_xqing on 2020/1/3.
 */
const val LOGIN_MODULE_TAG = "LOGIN_MODULE_TAG"

val loginModule = Kodein.Module(LOGIN_MODULE_TAG) {
    // 1、创建仓库 viewmodule、
    bind<LoginRepository>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        LoginRepository(instance())
    }

    bind<LoginViewModule>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        LoginViewModule.getInstance(fragment = context, repository = instance())
    }
}