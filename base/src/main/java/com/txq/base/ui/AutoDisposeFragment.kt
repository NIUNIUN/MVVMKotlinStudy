package com.txq.base.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider

/**
 * Created by tang_xqing on 2019/12/27.
 */
abstract class AutoDisposeFragment : Fragment() {
    protected val scopeProvider by lazy {
        AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY)
    }
}