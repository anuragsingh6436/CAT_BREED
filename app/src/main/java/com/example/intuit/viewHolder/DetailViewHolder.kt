package com.example.intuit.viewHolder

import android.view.View
import com.example.intuit.base.viewHolder.BaseViewHolder
import com.example.intuit.dataModel.DetailItemDataModel
import com.example.intuit.databinding.DetailRecyclerItemBinding


class DetailViewHolder(itemView: View, val dataBinding: DetailRecyclerItemBinding) :
    BaseViewHolder<DetailItemDataModel>(itemView) {

    override fun onBindData(item: DetailItemDataModel, position: Int) {
        with(dataBinding) {
            dataModel = item
            executePendingBindings()
        }
    }
}