package com.txq.templatee

class MVVMPresenter(view: MVVMContract.IView) : MVVMContract.IPresenter {
    val mView: MVVMContract.IView

    init {
        mView = view
    }
}

