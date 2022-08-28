package com.example.intuit.binding

import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.intuit.base.LinearLayoutItemData


@BindingAdapter(value = ["layoutItems"], requireAll = true)
fun bindData(linearLayout: LinearLayout, items: List<LinearLayoutItemData>?) {
    linearLayout.removeAllViews()
    if (items.isNullOrEmpty()) return
    val layoutInflater = LayoutInflater.from(linearLayout.context)
    try {
        for (item in items) {
            val binding: ViewDataBinding =
                DataBindingUtil.inflate(layoutInflater, item.layoutId, linearLayout, false)
            binding.setVariable(item.bindingId, item.data)
            binding.executePendingBindings()
            linearLayout.addView(binding.root)
        }
    } catch (e: Exception) {

    }
}