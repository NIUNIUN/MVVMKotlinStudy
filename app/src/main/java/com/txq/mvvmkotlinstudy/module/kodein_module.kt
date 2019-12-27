package com.txq.mvvmkotlinstudy.module

import androidx.core.content.FileProvider
import com.txq.mvvmkotlinstudy.ui.HomeFragment
import com.txq.mvvmkotlinstudy.ui.RepositoryFragment
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**  使用Kodein 进行依赖注入
 * Created by tang_xqing on 2019/12/26.
 */

const val MAIN_MODEULE_TAG = "main_module"
val mainModule = Kodein.Module(MAIN_MODEULE_TAG) {
    bind<HomeFragment>() with singleton { HomeFragment.getInstance() }
    bind<RepositoryFragment>() with singleton { RepositoryFragment.getInstance() }
}

const val HOME_MODULE_TAG = "home_module"
val homeModule = Kodein.Module(HOME_MODULE_TAG) {

}

const val REPOSITORY_MODULE_TAG = "repository_module"
val repositoryModule = Kodein.Module(REPOSITORY_MODULE_TAG) {

}


/**
 *  第三方库module依赖。一般用于Application，只初始一次。
 */
const val SDK_MODULE = "sdk_module"
val sdkModule = Kodein.Module(SDK_MODULE) {
    bind<FileProvider>() with singleton { FileProvider() }
}