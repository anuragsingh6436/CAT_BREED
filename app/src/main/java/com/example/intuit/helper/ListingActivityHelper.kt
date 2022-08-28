package com.example.intuit.helper

import androidx.lifecycle.MutableLiveData
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.constants.Constants.EMPTY_STRING
import com.example.intuit.dataModel.ListItemDataModel
import com.example.intuit.base.model.Event
import com.example.intuit.base.model.ListItemData
import com.example.intuit.model.response.BreedData
import javax.inject.Inject

class ListingActivityHelper @Inject constructor() {

    fun convertResponse(
        data: List<BreedData>,
        eventStream: MutableLiveData<Event>
    ): List<BaseRecyclerItem> {
        val itemsList = arrayListOf<BaseRecyclerItem>()
        data.forEachIndexed { index, it ->
            val itemData = ListItemData(
                id = it.id,
                name = it.name,
                temperament = it.temperament,
                origin = it.origin,
                imageUrl = it.image?.url ?: EMPTY_STRING
            )
            itemsList.add(
                ListItemDataModel(
                    listItemData = itemData,
                    position = index,
                    eventStream = eventStream
                )
            )
        }
        return itemsList
    }
}