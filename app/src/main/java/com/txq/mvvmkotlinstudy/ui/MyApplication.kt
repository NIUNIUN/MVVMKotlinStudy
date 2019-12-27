package com.txq.mvvmkotlinstudy.ui

import android.content.Context
import com.txq.base.ui.BaseInjectApplication
import com.txq.mvvmkotlinstudy.module.sdkModule
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

/**
 * Created by tang_xqing on 2019/12/27.
 */
class MyApplication : BaseInjectApplication() {
    override val kodein: Kodein = Kodein.lazy {
        // 这一句是什么意思
        bind<Context>() with singleton { this@MyApplication }
        import(sdkModule)
    }

}