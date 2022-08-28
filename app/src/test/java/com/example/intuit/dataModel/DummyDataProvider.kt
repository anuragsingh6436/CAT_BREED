package com.example.intuit.dataModel

import com.example.intuit.model.response.BreedData

class DummyDataProvider {

    fun getBreedList(): List<BreedData> {
        val list = arrayListOf<BreedData>()
        list.add(
            BreedData(
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
                wikipedia_url = null
            )
        )
        return list
    }
}