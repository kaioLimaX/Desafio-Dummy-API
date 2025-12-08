package com.skymobile.desafio_dummy_api.view

import com.skymobile.desafio_dummy_api.model.dto.products.Product

interface ProductView {
    fun showLoading()
    fun hideLoading()
    fun showProducts(products : List<Product>)
    fun showError(message : String)
}