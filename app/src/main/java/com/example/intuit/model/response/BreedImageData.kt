package com.example.intuit.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BreedImageData(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String?
) : Parcelable