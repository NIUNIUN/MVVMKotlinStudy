package com.txq.mvvmkotlinstudy.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by tang_xqing on 2019/12/26.
 */
class MainPagerAdapter(fragment: Fragment, fragments: MutableList<Fragment>) :
    FragmentStateAdapter(fragment) {

    var mFragments: MutableList<Fragment>

    init {
        mFragments = fragments
    }

    override fun getItemCount(): Int {
        return mFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragments.get(position)
    }
}