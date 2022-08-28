package com.example.intuit.dataModel

import androidx.lifecycle.MutableLiveData
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.adapter.AdapterItemKeys.Companion.LISTING_ITEM_TYPE1
import com.example.intuit.constants.Constants
import com.example.intuit.custom.RoundedTransformation
import com.example.intuit.base.model.Event
import com.example.intuit.base.model.ListItemData
import com.example.intuit.constants.EventConstants

class ListItemDataModel(val listItemData: ListItemData,val position:Int,val eventStream:MutableLiveData<Event>) :
    BaseRecyclerItem {

    fun applyTransformation(radius:Int,margin:Int): RoundedTransformation {
        return RoundedTransformation(radius, margin)
    }

    fun onItemClick() {
        eventStream.value = Event(EventConstants.LISTING_ITEM_CLiCK,position)
    }

    override fun getItemType(): Int {
        return LISTING_ITEM_TYPE1
    }
}