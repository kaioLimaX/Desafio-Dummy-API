package com.skymobile.desafio_dummy_api.view.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.skymobile.desafio_dummy_api.R
import com.skymobile.desafio_dummy_api.databinding.ActivityProductsBinding
import com.skymobile.desafio_dummy_api.view.controller.ProductController
import com.skymobile.desafio_dummy_api.view.model.dto.products.Product
import com.skymobile.desafio_dummy_api.view.view.adapter.ProductAdapter
import kotlinx.coroutines.launch

class ProductsActivity : AppCompatActivity(), ProductView {
    private val binding by lazy {
        ActivityProductsBinding.inflate(layoutInflater)
    }

    private val controller by lazy {
        ProductController(this)
    }

    private val adapter by lazy {
        ProductAdapter(emptyList()) { product ->
            Toast.makeText(this, "Clicou no produto: ${product.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupRecyclerView()

        lifecycleScope.launch{
            controller.loadProducts()
        }
    }

    private fun setupRecyclerView() {
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = adapter
    }


    override fun showLoading() {
        binding.progressBar3.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar3.visibility = View.GONE
    }

    override fun showProducts(products: List<Product>) {
        adapter.updateList(products)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}