package com.skymobile.desafio_dummy_api.view.model.repository

import com.skymobile.desafio_dummy_api.view.model.dto.products.Product


interface ProductRepository {
    suspend fun loadProducts() : Result<List<Product>>
}