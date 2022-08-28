package com.example.intuit.viewModel

import com.example.intuit.InstantExecutorExtension
import com.example.intuit.constants.Constants
import com.example.intuit.constants.EventConstants
import com.example.intuit.dataProvider.DummyDataProvider
import com.example.intuit.helper.ListingActivityHelper
import com.example.intuit.mockkCoroutine
import com.example.intuit.repository.ListingRepository
import com.example.intuit.unMockkCoroutine
import com.example.intuit.viewModel.ListingViewModel
import com.jraska.livedata.test
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.flowOf
import org.junit.After
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class ListingViewModelTest {
    private val repository: ListingRepository = mockk()
    private val helper: ListingActivityHelper = mockk()
    private lateinit var viewModel: ListingViewModel
    private val dataProvider = DummyDataProvider()

   @BeforeEach
   fun setUp() {
        MockKAnnotations.init(this)
        mockkCoroutine()
        viewModel = ListingViewModel(repository, helper)
    }

    @Test
    fun `test fetchApiFromServer`() {
        every { repository.getCatList(Constants.LISTING_URL) } returns flowOf(dataProvider.getBreedList())
        every { helper.convertResponse(any(),any()) } returns emptyList()
        viewModel.fetchDataFromApi()
        Assert.assertEquals(viewModel.itemsList.size, 0)
        Assert.assertEquals(viewModel.retryFlow.get(), false)
        Assert.assertEquals(viewModel.showShimmer.get(), false)
        viewModel.eventStream.test()
            .assertHasValue()
            .map {
                it.id
            }.assertValue(EventConstants.LISTING_API_RESPONSE)
    }

    @Test
    fun `test initiateRetryFlow function`() {
        every { repository.getCatList(Constants.LISTING_URL) } returns flowOf(dataProvider.getBreedList())
        every { helper.convertResponse(any(),any()) } returns emptyList()
        viewModel.initiateRetryFlow()
        Assert.assertEquals(viewModel.retryFlow.get(),false)
    }


    @After
    fun tearDown() {
        unmockkAll()
        unMockkCoroutine()
    }

}