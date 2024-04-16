package com.example.barcodeapp.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.barcodeapp.R
import com.example.barcodeapp.domain.models.Product
import com.squareup.picasso.Picasso

class ProductAdapter(val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        val name = item.findViewById<TextView>(R.id.tvProductName)
        val price = item.findViewById<TextView>(R.id.tvProductPrice)
        val image = item.findViewById<ImageView>(R.id.ivProductImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.name.text = product.name
        holder.price.text = product.priceFormatted
        Picasso.get().load(product.image).into(holder.image)
    }
}