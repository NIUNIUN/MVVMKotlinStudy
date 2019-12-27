package com.txq.mvvmkotlinstudy.ui

import android.content.Context
import android.content.Intent
import com.txq.base.ui.BaseActivity
import com.txq.mvvmkotlinstudy.R
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein
import java.util.concurrent.TimeUnit

class SecondActivity : BaseActivity() {
    override var layoutId: Int = R.layout.activity_second

    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
    }

    override fun initViews() {

    }

    override fun initData() {
        ttestMOut()
    }

    override fun initListener() {
    }

    fun ttestMOut() {
        Observable.interval(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .`as`(AutoDispose.autoDisposable<Long>(AndroidLifecycleScopeProvider.from(this)))
            .subscribe(object : Observer<Long> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Long) {
                    println("接收数据,当前线程 ${Thread.currentThread().getName()}  value =  $t")
                }

                override fun onError(e: Throwable) {
                }
            })
    }

    companion object {
        fun getInstance(context: Context) {
            context.startActivity(Intent(context, SecondActivity::class.java))
        }
    }
}
