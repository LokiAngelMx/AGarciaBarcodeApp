package com.example.barcodeapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.barcodeapp.data.dao.ProductDao
import com.example.barcodeapp.domain.models.Product

@Database(entities = [Product::class], version = 1)
abstract class BarcodeDb: RoomDatabase() {
    abstract fun productDao(): ProductDao
}