package com.example.intuit.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.intuit.base.viewHolder.BaseViewHolder

abstract class BaseAdapter: RecyclerView.Adapter<BaseViewHolder<BaseRecyclerItem>>() {

    abstract override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BaseRecyclerItem>

    val items = ArrayList<BaseRecyclerItem>()

    fun setItems(items:ArrayList<BaseRecyclerItem>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

}