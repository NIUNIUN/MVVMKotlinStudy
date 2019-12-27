package com.txq.base.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Created by tang_xqing on 2019/12/27.
 */
abstract class BaseViewModule(application: Application) : AndroidViewModel(application),IViewModule {
}