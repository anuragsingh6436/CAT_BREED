package com.example.intuit.base.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<V>(itemView:View): RecyclerView.ViewHolder(itemView) {

    abstract fun onBindData(item: V, position: Int)
}