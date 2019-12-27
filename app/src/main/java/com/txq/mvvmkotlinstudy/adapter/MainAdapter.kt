package com.txq.mvvmkotlinstudy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.txq.mvvmkotlinstudy.R

/**
 * Created by tang_xqing on 2019/12/26.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView

        init {
            textView =itemView.findViewById(R.id.tv_main)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_layout, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.setText("ViewPager2 position=$position")
    }
}