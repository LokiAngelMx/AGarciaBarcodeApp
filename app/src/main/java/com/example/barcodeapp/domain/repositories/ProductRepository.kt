package com.example.barcodeapp.domain.repositories

import com.example.barcodeapp.domain.models.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
}