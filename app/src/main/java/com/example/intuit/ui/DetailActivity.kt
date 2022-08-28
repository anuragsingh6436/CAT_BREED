package com.example.intuit.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.intuit.R
import com.example.intuit.base.executeIfCast
import com.example.intuit.base.model.Event
import com.example.intuit.constants.Constants
import com.example.intuit.constants.EventConstants
import com.example.intuit.databinding.ActivityDetailBinding
import com.example.intuit.di.getViewModel
import com.example.intuit.model.response.BreedData
import com.example.intuit.viewModel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    lateinit var viewModel: DetailViewModel
    lateinit var dataBinding: ActivityDetailBinding
    private val bundleData by lazy { intent.extras?.getParcelable<BreedData>(Constants.INTENT_DATA) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDynamicTheme()
        setContentView(R.layout.activity_detail)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        viewModel = getViewModel()
        dataBinding.viewModel = viewModel

        viewModel.eventStream.observe(this) {
            handleEvents(it)
        }

        setDataToViewModel()
    }

    private fun setDynamicTheme() {
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun setDataToViewModel() {
        bundleData?.let {
            viewModel.data = it
            viewModel.addItemsToRecyclerView()
        } ?: kotlin.run {
            showToastAndFinish(EventConstants.DETAIL_DATA_NULL_TOAST_MESSAGE)
        }
    }

    private fun handleEvents(event: Event) {
        when (event.id) {
            EventConstants.OPEN_WEB_URL -> {
                event.data.executeIfCast<String> {
                    openWebUrl(url = this)
                }
            }
        }
    }

    private fun openWebUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun showToastAndFinish(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        finish()
    }
}