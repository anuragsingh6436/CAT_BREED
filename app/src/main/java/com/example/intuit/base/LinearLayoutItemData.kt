package com.example.intuit.base

import androidx.annotation.LayoutRes

data class LinearLayoutItemData(
    @LayoutRes val layoutId: Int,
    val bindingId: Int,
    val data: Any
)