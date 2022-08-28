package com.example.intuit.dataModel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.example.intuit.BR
import com.example.intuit.R
import com.example.intuit.adapter.AdapterItemKeys
import com.example.intuit.base.LinearLayoutItemData
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.base.model.Event
import com.example.intuit.constants.Constants
import com.example.intuit.constants.EventConstants
import com.example.intuit.model.response.BreedData

class DetailItemDataModel(val data: BreedData, val eventStream: MutableLiveData<Event>) :
    BaseRecyclerItem {

    val layoutItems = ObservableArrayList<LinearLayoutItemData>()

    init {
        addRatingInfos()
    }

    private fun addRatingInfos() {
        val list = arrayListOf<LinearLayoutItemData>()
        //affection level
        data.affection_level?.let {
            list.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.AFFECTION_LEVEL, it)
                )
            )
        }
        //child friendly
        data.child_friendly?.let {
            list.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.CHILD_FRIENDLY, it)
                )
            )
        }
        //dog friendly
        data.dog_friendly?.let {
            list.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.DOG_FRIENDLY, it)
                )
            )
        }
        //energy level
        data.energy_level?.let {
            list.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.ENERGY_LEVEL, it)
                )
            )
        }
        //health issues
        data.health_issues?.let {
            list.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.HEALTH_ISSUES, it)
                )
            )
        }
        //intelligence
        data.intelligence?.let {
            list.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.INTELLIGENCE, it)
                )
            )
        }
        //social needs
        data.social_needs?.let {
            list.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.SOCIAL_NEEDS, it)
                )
            )
        }
        layoutItems.addAll(list)
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