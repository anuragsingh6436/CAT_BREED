package com.example.intuit.dataProvider

import com.example.intuit.base.adapter.BaseRecyclerItem
import com.example.intuit.base.model.ListItemData
import com.example.intuit.model.response.BreedData

class DummyDataProvider {

    fun getBreedList(): List<BreedData> {
        val list = arrayListOf<BreedData>()
        list.add(getBreedData())
        return list
    }

    fun getBreedData(): BreedData {
        return BreedData(
            id = "id",
            name = "name",
            temperament = "temperament",
            origin = "origin",
            image = null,
            description = "desc",
            life_span = "life_span",
            indoor = 0,
            health_issues = 0,
            intelligence = 0,
            adaptability = 0,
            affection_level = 0,
            child_friendly = 0,
            dog_friendly = 0,
            energy_level = 0,
            lap = 0,
            shedding_level = 0,
            social_needs = 0,
            wikipedia_url = "wikipedia_url"
        )
    }

    fun provideListItemData(): ListItemData {
        return ListItemData(
            temperament = "temperament",
            id = "id",
            name = "name",
            imageUrl = "imageUrl",
            origin = "origin"
        )
    }
}