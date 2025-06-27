package com.example.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.food.R
import com.example.food.databinding.FragmentLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class Fragment_login : Fragment() {

private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.forgotPassword.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.fragment_password_2, null)
            bottomSheetDialog.setContentView(view)

// Tugmani ishlatish

            bottomSheetDialog.show()
        }
        return binding.root
    }


}