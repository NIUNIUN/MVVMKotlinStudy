package com.txq.mvvmkotlinstudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.txq.mvvmkotlinstudy.R

/**
 * Created by tang_xqing on 2019/12/26.
 */
class RepositoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_repository, container, false)
    }

    companion object {
        fun getInstance(): RepositoryFragment {
            return RepositoryFragment()
        }
    }
}