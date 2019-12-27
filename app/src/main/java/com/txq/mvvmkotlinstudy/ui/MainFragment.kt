package com.txq.mvvmkotlinstudy.ui

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.txq.base.ui.BaseFragment
import com.txq.base.util.TabLayoutMediator
import com.txq.mvvmkotlinstudy.R
import com.txq.mvvmkotlinstudy.adapter.MainPagerAdapter
import com.txq.mvvmkotlinstudy.module.mainModule
import kotlinx.android.synthetic.main.fragment_main.*
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

/**
 * Created by tang_xqing on 2019/12/26.
 */
class MainFragment : BaseFragment() {

    val tabTitle = arrayOf("首页", "仓库")
    val homeFragment: HomeFragment by instance()
    val repositoryFragment: RepositoryFragment by instance()

    override var layoutId: Int = R.layout.fragment_main

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        import(mainModule)
        bind<FragmentManager>() with instance(childFragmentManager)
    }

    override fun initViews() {
        // 设置滑动方向。可以垂直方向滑动
        vp2_main.orientation = ViewPager2.ORIENTATION_VERTICAL

        vp2_main.adapter = MainPagerAdapter(this, mutableListOf(homeFragment, repositoryFragment))

        var headerView = nv_main.getHeaderView(0)
        var headerImg = headerView.findViewById<ImageView>(R.id.iv_header_img)
        headerImg.setOnClickListener {
            Toast.makeText(activity, "点击头像", Toast.LENGTH_SHORT).show()
        }

        nv_main.setNavigationItemSelectedListener {
            Toast.makeText(
                activity,
                "点击 ${it.title}",
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        tv_nv.setOnClickListener {
            Toast.makeText(
                activity,
                "点击 抽屉布局",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun initListener() {
        // Tablayout + ViewPager2 联动
        TabLayoutMediator(tab_main, vp2_main) { tab, position ->
            tab.setText(tabTitle[position])
        }.attach()
    }

    override fun initData() {

    }
}