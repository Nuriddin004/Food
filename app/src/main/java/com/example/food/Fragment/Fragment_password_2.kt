package com.example.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.food.R

class Fragment_password_2 : Fragment() {

    private lateinit var cardWhatsapp: LinearLayout
    private lateinit var cardEmail: LinearLayout
    private lateinit var checkWhatsapp: ImageView
    private lateinit var checkEmail: ImageView
    private lateinit var btnContinue: Button

    private var selectedMethod: String = "whatsapp" // default

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_password_2, container, false)

        // Elementlarni aniqlash
        cardWhatsapp = view.findViewById(R.id.card_whatsapp)
        cardEmail = view.findViewById(R.id.card_email)
        checkWhatsapp = view.findViewById(R.id.check_whatsapp)
        checkEmail = view.findViewById(R.id.check_email)
        btnContinue = view.findViewById(R.id.btn_continue)

        setupClicks()

        return view
    }

    private fun setupClicks() {
        cardWhatsapp.setOnClickListener {
            selectOption("whatsapp")
        }

        cardEmail.setOnClickListener {
            selectOption("email")
        }

        btnContinue.setOnClickListener {
            Toast.makeText(requireContext(), "Selected: $selectedMethod", Toast.LENGTH_SHORT).show()
            // Keyingi ekran yoki operatsiyaga yo'naltirish shu yerda yoziladi
        }
    }

    private fun selectOption(method: String) {
        if (method == "whatsapp") {
            selectedMethod = "whatsapp"
            cardWhatsapp.setBackgroundResource(R.drawable.bg_selected_option)
            cardEmail.setBackgroundResource(R.drawable.bg_unselected_option)
            checkWhatsapp.visibility = View.VISIBLE
            checkEmail.visibility = View.GONE
        } else {
            selectedMethod = "email"
            cardEmail.setBackgroundResource(R.drawable.bg_selected_option)
            cardWhatsapp.setBackgroundResource(R.drawable.bg_unselected_option)
            checkEmail.visibility = View.VISIBLE
            checkWhatsapp.visibility = View.GONE
        }
    }
}
