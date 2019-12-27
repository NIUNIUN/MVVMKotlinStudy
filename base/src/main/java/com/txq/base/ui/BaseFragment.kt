package com.txq.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

/**
 * Created by tang_xqing on 2019/12/27.
 */
abstract class BaseFragment : AutoDisposeFragment(), KodeinAware, IFragment {
    val parentKodein by closestKodein()

    protected abstract var layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        initData()
        initListener()
    }
}