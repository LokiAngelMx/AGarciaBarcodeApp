package com.example.barcodeapp.presentation.states

import com.example.barcodeapp.domain.models.Product

data class ProductState (
    val products: List<Product> = emptyList(),
    val shoppingCartProduct: List<Product> = emptyList(),
)