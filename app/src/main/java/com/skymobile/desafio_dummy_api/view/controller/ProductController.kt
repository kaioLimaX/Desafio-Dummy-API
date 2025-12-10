package com.skymobile.desafio_dummy_api.view.controller

import com.skymobile.desafio_dummy_api.view.model.repository.ProductRepository
import com.skymobile.desafio_dummy_api.view.model.repository.ProductRepositoryImpl
import com.skymobile.desafio_dummy_api.view.view.ProductView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ProductController(
    private val view: ProductView
) {
    val repository: ProductRepository = ProductRepositoryImpl()

    suspend fun loadProducts() {
        try {
            view.showLoading()
            delay(2000L) // Simula um tempo de carregamento
            val response = withContext(Dispatchers.IO) {
                repository.loadProducts().getOrThrow()
            }

            view.showProducts(response)

        } catch (e: Exception) {
            view.showError("Erro: ${e.message}")
        } finally {
            view.hideLoading()
        }
    }
}