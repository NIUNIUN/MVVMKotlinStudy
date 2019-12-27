package com.txq.base.ui

import android.os.Bundle
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.kcontext

/**
 * Created by tang_xqing on 2019/12/27.
 */
abstract class BaseActivity : AutoDisposeActivity(), KodeinAware, IActivity {

    abstract var layoutId: Int

    val parentKodein by closestKodein()

    override val kodeinContext: KodeinContext<*> = kcontext(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initViews()
        initData()
        initListener()
    }
}