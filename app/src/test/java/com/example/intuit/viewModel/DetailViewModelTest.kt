package com.example.intuit.viewModel

import com.example.intuit.InstantExecutorExtension
import com.example.intuit.dataProvider.DummyDataProvider
import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dataProvider = DummyDataProvider()

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = DetailViewModel()
    }

    @Test
    fun `test addItemsToRecyclerView function`() {
        //when data is null
        viewModel.data = null
        viewModel.addItemsToRecyclerView()
        Assert.assertEquals(viewModel.itemsList.size, 0)
        //when data is there
        viewModel.data = dataProvider.getBreedData()
        viewModel.addItemsToRecyclerView()
        Assert.assertEquals(viewModel.itemsList.size, 1)
    }


    @Test
    fun `test getSpanText function`() {
        //when data is null
        viewModel.data = null
        Assert.assertEquals(viewModel.getSpanText(),null)
        //when data is there
        viewModel.data = dataProvider.getBreedData()
        Assert.assertEquals(viewModel.getSpanText(),"life_spanyears")
    }


    @After
    fun tearDown() {
        unmockkAll()
    }

}