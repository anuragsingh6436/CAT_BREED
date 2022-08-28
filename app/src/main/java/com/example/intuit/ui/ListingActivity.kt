package com.example.intuit.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.dagger.custom.VerticalItemDecorator
import com.example.intuit.R
import com.example.intuit.base.executeIfCast
import com.example.intuit.constants.Constants
import com.example.intuit.databinding.ActivityListingBinding
import com.example.intuit.di.getViewModel
import com.example.intuit.base.model.Event
import com.example.intuit.constants.EventConstants
import com.example.intuit.model.response.BreedData
import com.example.intuit.viewModel.ListingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListingActivity : AppCompatActivity() {

    lateinit var listingViewModel: ListingViewModel
    lateinit var dataBinding: ActivityListingBinding

    var listingResponse: List<BreedData>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_listing)

        listingViewModel = getViewModel()
        dataBinding.viewModel = listingViewModel
        listingViewModel.eventStream.observe(this) {
            handleEvents(it)
        }

        addItemDecoration()
        fetchData()
    }

    private fun fetchData() {
        listingViewModel.fetchDataFromApi()
    }

    private fun addItemDecoration() {
        with(dataBinding) {
            recyclerView.addItemDecoration(VerticalItemDecorator(20))

        }
    }

    private fun handleEvents(event: Event) {
        when (event.id) {
            Constants.API_ERROR -> {
                Toast.makeText(this, EventConstants.API_ERROR_TOAST_MESSAGE, Toast.LENGTH_LONG)
                    .show()
            }
            EventConstants.LISTING_ITEM_CLiCK -> {
                event.data.executeIfCast<Int> {
                    openDetailActivity(this)
                }
            }
            EventConstants.LISTING_API_RESPONSE -> {
                event.data.executeIfCast<List<BreedData>> {
                    listingResponse = this
                }
            }
        }
    }

    private fun openDetailActivity(position: Int) {
        listingResponse?.let { listingResponse ->
            val intent = Intent(this, DetailActivity::class.java)
            val bundle = Bundle().also {
                it.putParcelable(Constants.INTENT_DATA, listingResponse[position])
            }
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}