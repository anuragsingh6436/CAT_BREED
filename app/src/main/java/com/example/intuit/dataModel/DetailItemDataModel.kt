package com.example.intuit.dataModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.example.intuit.adapter.AdapterItemKeys
import com.example.intuit.base.LinearLayoutItemData
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.base.model.Event
import com.example.intuit.constants.EventConstants
import com.example.intuit.helper.DetailDataHelper
import com.example.intuit.model.response.BreedData

class DetailItemDataModel(val data: BreedData, val eventStream: MutableLiveData<Event>) :
    BaseRecyclerItem {

    val detailHelper = DetailDataHelper()
    val layoutItems = ObservableArrayList<LinearLayoutItemData>()

    init {
        addRatingInfos()
    }

    private fun addRatingInfos() {
        layoutItems.addAll(detailHelper.getRatingItems(data))
    }

    override fun getItemType(): Int {
        return AdapterItemKeys.DETAIL_ITEM_TYPE
    }

    fun openWebUrl() {
        data.wikipedia_url?.let{
            eventStream.postValue(Event(EventConstants.OPEN_WEB_URL,it))
        }
    }
}