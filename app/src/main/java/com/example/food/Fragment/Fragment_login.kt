package com.example.food.Fragment

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.food.R
import com.example.food.databinding.DialogBinding
import com.example.food.databinding.FragmentLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class Fragment_login : Fragment() {

private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.forgotPassword.setOnClickListener {

                val dialog = Dialog(requireContext())
                val  dilal=DialogBinding.inflate(layoutInflater)
                dilal.cardWhatsapp.setOnClickListener {
                    dilal.checkWhatsapp.visibility = View.VISIBLE
                    dilal.checkEmail.visibility = View.GONE
                }

                dilal.cardEmail.setOnClickListener {
                    dilal.checkWhatsapp.visibility = View.GONE
                    dilal.checkEmail.visibility = View.VISIBLE
                }
                dialog.setContentView(dilal.root)
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialog.show()
            }
        binding.registerButton.setOnClickListener{
            findNavController().navigate(R.id.action_fragment_login4_to_fragment_creat)


        }
        binding.signbutton.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_login4_to_homev1Fragment)

        }

        return binding.root
    }


}