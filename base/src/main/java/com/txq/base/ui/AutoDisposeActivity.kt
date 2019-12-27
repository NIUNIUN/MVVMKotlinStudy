package com.txq.base.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider

/**
 * Created by tang_xqing on 2019/12/27.
 */
abstract class AutoDisposeActivity : AppCompatActivity() {

  protected  val scopeProvider by lazy {
        AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY)
    }
}