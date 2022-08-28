package com.example.intuit.viewModel

import androidx.databinding.ObservableArrayList
import com.example.intuit.adapter.DetailAdapter
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.base.viewModel.BaseViewModel
import com.example.intuit.constants.Constants
import com.example.intuit.custom.RoundedTransformation
import com.example.intuit.dataModel.DetailItemDataModel
import com.example.intuit.model.response.BreedData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : BaseViewModel() {

    var data: BreedData? = null
    val adapter = DetailAdapter()
    val itemsList = ObservableArrayList<BaseRecyclerItem>()

    fun addItemsToRecyclerView() {
        data?.let {
            itemsList.add(DetailItemDataModel(it, eventStream))
        }
    }

    fun applyTransformation(radius: Int, margin: Int): RoundedTransformation {
        return RoundedTransformation(radius, margin)
    }

    fun getSpanText(): String? {
        data?.let {
            return it.life_span + Constants.EMPTY_STRING + Constants.YEARS
        }
        return null
    }

}