package com.txq.base.util

import androidx.lifecycle.LifecycleOwner
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.AutoDisposeConverter
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider

/**
 * Created by tang_xqing on 2019/12/27.
 */
class RxLifecyclerUtil {
    companion object {
        /**
         * 将RxJava与生命周期绑定在一起
         */
        fun <T> bindLifecycler(lifecyclerOwner: LifecycleOwner): AutoDisposeConverter<T> {
            return AutoDispose.autoDisposable<T>(AndroidLifecycleScopeProvider.from(lifecyclerOwner))
        }
    }
}