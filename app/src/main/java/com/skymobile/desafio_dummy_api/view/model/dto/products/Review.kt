package com.skymobile.desafio_dummy_api.view.model.dto.products


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Review(
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
) : Parcelable