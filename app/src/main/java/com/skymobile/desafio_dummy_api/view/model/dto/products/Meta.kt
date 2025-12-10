package com.skymobile.desafio_dummy_api.view.model.dto.products


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Meta(
    val barcode: String,
    val createdAt: String,
    val qrCode: String,
    val updatedAt: String
) : Parcelable