package com.example.intuit.viewModel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.viewModelScope
import com.example.intuit.adapter.ListingAdapter
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.base.viewModel.BaseViewModel
import com.example.intuit.constants.Constants
import com.example.intuit.constants.Constants.LISTING_URL
import com.example.intuit.helper.ListingDataHelper
import com.example.intuit.base.model.Event
import com.example.intuit.constants.EventConstants
import com.example.intuit.repository.ListingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    val repository: ListingRepository,
    val helper: ListingDataHelper
) : BaseViewModel() {

    val adapter = ListingAdapter()
    val itemsList = ObservableArrayList<BaseRecyclerItem>()
    val showShimmer = ObservableBoolean(true)
    val retryFlow = ObservableBoolean(false)

    fun fetchDataFromApi() {
        showShimmer.set(true)
        viewModelScope.launch {
            repository.getCatList(LISTING_URL)
                .catch {
                    eventStream.postValue(Event(Constants.API_ERROR))
                    showShimmer.set(false)
                    retryFlow.set(true)
                }.collect {
                    eventStream.postValue(Event(EventConstants.LISTING_API_RESPONSE,it))
                    val recyclerItems = helper.convertResponse(it, eventStream)
                    itemsList.addAll(recyclerItems)
                    showShimmer.set(false)
                }
        }
    }

    fun initiateRetryFlow() {
        retryFlow.set(false)
        fetchDataFromApi()
    }
}