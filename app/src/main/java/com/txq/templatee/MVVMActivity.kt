package com.txq.templatee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.txq.mvvmkotlinstudy.R

class MVVMActivity : AppCompatActivity(), MVVMContract.IView {

    private val mPresenter: MVVMPresenter by lazy {
        MVVMPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
    }
}