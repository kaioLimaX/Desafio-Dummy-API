package com.skymobile.desafio_dummy_api.view.model.api

import com.skymobile.desafio_dummy_api.view.model.dto.products.ProductsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductsResponse
}