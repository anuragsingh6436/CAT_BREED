package com.example.intuit.dataModel

import androidx.lifecycle.MutableLiveData
import com.example.intuit.InstantExecutorExtension
import com.example.intuit.adapter.AdapterItemKeys
import com.example.intuit.base.model.Event
import com.example.intuit.constants.EventConstants
import com.example.intuit.dataProvider.DummyDataProvider
import com.jraska.livedata.test
import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class DetailItemDataModelTest {
    lateinit var dataItemDataModel: DetailItemDataModel
    lateinit var eventStream: MutableLiveData<Event>
    private val dataProvider = DummyDataProvider()

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init()
        eventStream = MutableLiveData()
        dataItemDataModel = DetailItemDataModel(dataProvider.getBreedData(), eventStream)
    }

    @Test
    fun `test rating info data`() {
        //as we are passing data in mock response so total 7 items are to be added
        Assert.assertEquals(dataItemDataModel.layoutItems.size, 7)
    }

    @Test
    fun `openWebUrl function`() {
        dataItemDataModel.openWebUrl()
        dataItemDataModel.eventStream.test().assertHasValue().map {
            it.id
        }.assertValue(EventConstants.OPEN_WEB_URL)
    }

    @Test
    fun `test ItemType`() {
        Assert.assertEquals(dataItemDataModel.getItemType(), AdapterItemKeys.DETAIL_ITEM_TYPE)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}