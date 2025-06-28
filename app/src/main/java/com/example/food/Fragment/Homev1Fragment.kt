package com.example.food.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food.R
import com.example.food.adapter.ProductAdapter
import com.example.food.clas.Product


class Homev1Fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter
    private lateinit var productList: List<Product>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_homev1, container, false)

        recyclerView = view.findViewById(R.id.rvProducts)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        productList = listOf(
            Product("Ordinary Burgers", 4.9, "190m", "17,230", R.drawable.burger_katta),
            Product("Chicken Taco", 4.7, "250m", "13,000", R.drawable.taco),
            Product("Fresh Juice", 4.8, "120m", "9,500", R.drawable.drink),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza),
            Product("Pepperoni Pizza", 4.5, "300m", "22,000", R.drawable.piza)

        )

        adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter

        return view
    }
}
