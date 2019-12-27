package com.txq.mvvmkotlinstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.txq.base.ui.BaseActivity
import org.kodein.di.Kodein
import org.kodein.di.android.retainedKodein

class MainActivity : BaseActivity() {
    override var layoutId: Int = R.layout.activity_main

    /**
     * 将onBack事件委托给Navigation
     */
    override fun supportNavigateUpTo(upIntent: Intent) {
        findNavController(this, R.id.fg_main).navigateUp()
    }

    override val kodein: Kodein by retainedKodein {
        // retainedKodein：横竖屏切换时，不会创建新的Kodein
    }

    override fun initViews() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }

}
