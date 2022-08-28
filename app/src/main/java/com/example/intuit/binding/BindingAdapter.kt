package com.example.intuit.binding

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.intuit.base.adapter.BaseAdapter
import com.example.intuit.base.adapter.BaseRecyclerItem
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation


@BindingAdapter(value = ["imageUrl", "placeholder", "applyTransformation"], requireAll = false)
fun getImage(
    view: AppCompatImageView,
    imageUrl: String?,
    placeHolder: Int,
    transformation: Transformation? = null
) {
    view.setImageResource(placeHolder)

    if (imageUrl.isNullOrEmpty()) {
        return
    }
    val request = Picasso.get().load(imageUrl)
    transformation?.let {
        request.transform(it)
    }
    try {
        request.into(view)
    } catch (e: Exception) {
        view.setImageResource(placeHolder)
    }
}

@BindingAdapter(value = ["adapter", "itemsList"], requireAll = true)
fun updateRecyclerView(
    recyclerView: RecyclerView,
    adapter: BaseAdapter,
    itemsList: ArrayList<BaseRecyclerItem>
) {
    if (recyclerView.adapter == null) recyclerView.adapter = adapter
    if (itemsList.isNotEmpty()) {
        adapter.setItems(itemsList)
    }
}

@BindingAdapter(value = ["visibleGone"], requireAll = true)
fun toggleView(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}




