package com.example.intuit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.intuit.R
import com.example.intuit.base.adapter.BaseAdapter
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.base.viewHolder.BaseViewHolder
import com.example.intuit.databinding.ListRecyclerItemsBinding
import com.example.intuit.viewHolder.ListingViewHolder

class ListingAdapter: BaseAdapter() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<BaseRecyclerItem> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val dataBinding: ListRecyclerItemsBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_recycler_items, parent, false
        )
        return ListingViewHolder(dataBinding.root, dataBinding) as BaseViewHolder<BaseRecyclerItem>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseRecyclerItem>, position: Int) {
        holder.onBindData(this.items[position], position)
    }
}