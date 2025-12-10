package com.skymobile.desafio_dummy_api.view.model.repository

import com.skymobile.desafio_dummy_api.view.model.api.ApiService
import com.skymobile.desafio_dummy_api.view.model.api.RetrofitClient
import com.skymobile.desafio_dummy_api.view.model.dto.products.Product

class ProductRepositoryImpl : ProductRepository {

    val api = RetrofitClient.instance.create(ApiService::class.java)

    override suspend fun loadProducts(): Result<List<Product>> {
        return try {
            val result = api.getProducts()
            Result.success(result.products)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}