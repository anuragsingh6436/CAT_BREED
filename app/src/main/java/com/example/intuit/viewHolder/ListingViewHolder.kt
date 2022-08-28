package com.example.intuit.viewHolder

import android.view.View
import com.example.intuit.base.viewHolder.BaseViewHolder
import com.example.intuit.dataModel.ListItemDataModel
import com.example.intuit.databinding.ListRecyclerItemsBinding

class ListingViewHolder(itemView: View, val dataBinding: ListRecyclerItemsBinding) :
    BaseViewHolder<ListItemDataModel>(itemView) {

    override fun onBindData(item: ListItemDataModel, position: Int) {
        with(dataBinding) {
            dataModel = item
            executePendingBindings()
        }
    }
}