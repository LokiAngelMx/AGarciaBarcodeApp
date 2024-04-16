package com.example.barcodeapp.data.repositories

import com.example.barcodeapp.data.dao.ProductDao
import com.example.barcodeapp.domain.models.Product
import com.example.barcodeapp.domain.repositories.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> {
        return productDao.getAllProducts()
    }

}