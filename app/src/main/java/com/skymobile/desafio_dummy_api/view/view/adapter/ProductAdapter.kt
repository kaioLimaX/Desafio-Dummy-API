package com.skymobile.desafio_dummy_api.view.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.skymobile.desafio_dummy_api.databinding.ItemProductBinding
import com.skymobile.desafio_dummy_api.view.model.dto.products.Product

class ProductAdapter(
    private var items: List<Product>,
    private val onClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product) {
            binding.tvTitle.text = item.title
            binding.tvPrice.text = "Preço: R$ ${item.price}"
            binding.tvDetails.text = item.description ?: "Sem detalhes"
            binding.imgProduct.load(item.images.firstOrNull())

            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateList(newList: List<Product>) {
        items = newList
        notifyDataSetChanged()
    }
}