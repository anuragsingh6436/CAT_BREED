package com.example.intuit.base.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intuit.base.model.Event

abstract class BaseViewModel : ViewModel() {

    val eventStream = MutableLiveData<Event>()

}