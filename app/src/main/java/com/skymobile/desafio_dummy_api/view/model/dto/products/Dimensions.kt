package com.skymobile.desafio_dummy_api.view.model.dto.products


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Dimensions(
    val depth: Double,
    val height: Double,
    val width: Double
) : Parcelable