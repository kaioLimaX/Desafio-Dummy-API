package com.skymobile.desafio_dummy_api

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.skymobile.desafio_dummy_api.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
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

        //navegar para tela de produtos
        binding.btnProdutos.setOnClickListener {
            //navegateTo(ProdutosActivity())
        }
        //navegar para tela de clientes
        binding.btnUsuarios.setOnClickListener {
            //navegateTo(UsuariosActivity())
        }
        //navegar para tela de pedidos
        binding.btnCart.setOnClickListener {
            //navegateTo(CartActivity())
        }
        //navegar para tela de postagens
        binding.btnPostagens.setOnClickListener {
            //navegateTo(PostagensActivity())
        }


    }

    private fun navegateTo(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }
}