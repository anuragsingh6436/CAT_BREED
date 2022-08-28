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
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class ListItemDataModelTest {
    lateinit var itemDataModel: ListItemDataModel
    lateinit var eventStream: MutableLiveData<Event>
    private val dataProvider = DummyDataProvider()

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init()
        eventStream = MutableLiveData()
        itemDataModel = ListItemDataModel(dataProvider.provideListItemData(), 0, eventStream)
    }

    @Test
    fun `test onItemClick`() {
        itemDataModel.onItemClick()
        itemDataModel.eventStream.test().assertHasValue().map {
            it.id
        }.assertValue(EventConstants.LISTING_ITEM_CLiCK)
    }

    @Test
    fun `test ItemType`() {
        Assert.assertEquals(itemDataModel.getItemType(), AdapterItemKeys.LISTING_ITEM_TYPE1)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}