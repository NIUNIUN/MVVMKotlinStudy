package com.txq.mvvmkotlinstudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.txq.mvvmkotlinstudy.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by tang_xqing on 2019/12/26.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_jump.setOnClickListener {
            SecondActivity.getInstance(this.context!!)
        }
    }

    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}