package com.example.food.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food.R
import com.example.food.clas.Product

class ProductAdapter (private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        val tvDistance: TextView = itemView.findViewById(R.id.tvDistance)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val btnLike: ImageView = itemView.findViewById(R.id.btnLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.imgProduct.setImageResource(product.imageResId)
        holder.tvTitle.text = product.title
        holder.tvRating.text = "⭐ ${product.rating}"
        holder.tvDistance.text = "📍${product.distance}"
        holder.tvPrice.text = "$ ${product.price}"
    }

    override fun getItemCount(): Int = productList.size
}

