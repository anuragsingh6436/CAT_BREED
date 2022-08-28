package com.example.intuit.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BreedData(
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val image: BreedImageData?,
    val description: String,
    val life_span: String,
    val indoor: Int?,
    val lap: Int?,
    val adaptability: Int?,
    val affection_level: Int?,
    val child_friendly: Int?,
    val dog_friendly: Int?,
    val energy_level: Int?,
    val health_issues: Int?,
    val intelligence: Int?,
    val shedding_level: Int?,
    val social_needs: Int?,
    val wikipedia_url: String?
) : Parcelable


