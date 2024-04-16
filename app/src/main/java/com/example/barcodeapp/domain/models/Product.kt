package com.example.barcodeapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product
    (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val barcode: String,
    val name: String,
    val price: Double,
    val image: String
    ){
    val priceFormatted: String get() = "$$price"

    companion object{
        val products = listOf<Product>(
            Product(1, "6927534810476", "Vaso Bob Esponja", 10.0, "https://i5.walmartimages.com.mx/gr/images/product-images/img_large/00692753481047L.jpg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"),
            Product(2, "6953176653669", "Bote de basura", 20.0, "https://i5.walmartimages.com.mx/gr/images/product-images/img_large/00695317665366L.jpg"),
            Product(3, "7501011123588", "Doritos", 30.0, "https://www.smartnfinal.com.mx/wp-content/uploads/2021/05/90041-Doritos-nacho-super-size-Sabritas-650-g.jpg"),
            Product(4, "7500478016587", "Churrumais", 40.0, "https://i5.walmartimages.com.mx/gr/images/product-images/img_large/00750047800255L.jpg?odnHeight=612&odnWidth=612&odnBg=FFFFFF"),
        )
    }
}