package com.txq.mvvmkotlinstudy.ui

import com.txq.base.ui.BaseActivity
import com.txq.mvvmkotlinstudy.R
import com.txq.mvvmkotlinstudy.module.loginModule
import com.txq.mvvmkotlinstudy.viewmodule.LoginViewModule
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

class LoginActivity : BaseActivity() {
    override var layoutId: Int = R.layout.activity_login

    override val kodein: Kodein by retainedKodein{
        extend(parentKodein)
        import(loginModule)
    }

    val mLoginViewModule:LoginViewModule by instance()

    override fun initViews() {

        btn_ok.setOnClickListener {
            // 进行登陆请求，登陆成功跳转到详情页

        }
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}
