package com.example.food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.food.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // BottomNavigationView ni NavController bilan bog‘lash
        val navController = findNavController(R.id.homev1Fragment)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }

    // Back tugmasi bosilganda orqaga navigatsiya qilish uchun
    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.homev1Fragment).navigateUp()
}