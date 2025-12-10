package com.skymobile.desafio_dummy_api.view.model.dto.products


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ProductsResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
) : Parcelable