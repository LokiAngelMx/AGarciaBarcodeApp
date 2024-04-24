package com.example.barcodeapp.domain.use_cases

import com.example.barcodeapp.domain.models.Product
import com.example.barcodeapp.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProducts (private val repository: ProductRepository
) {
    suspend operator fun invoke() : Flow<List<Product>> {
        return repository.getAllProducts()
    }
}