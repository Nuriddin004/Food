package com.example.food.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.food.R
import com.example.food.databinding.DialogBinding
import com.example.food.databinding.FragmentPasswordBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_password.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_password : Fragment() {
    private val binding by lazy { FragmentPasswordBinding.inflate(layoutInflater) }
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.continueButton.setOnClickListener {
            var check=0

            val dialog = BottomSheetDialog(requireContext())
            val  dilal=DialogBinding.inflate(layoutInflater)
            dilal.cardWhatsapp.setOnClickListener {
                check=1
                dilal.checkWhatsapp.visibility = View.VISIBLE
                dilal.checkEmail.visibility = View.GONE
                dilal.cardWhatsapp.setBackgroundResource(R.drawable.bg_selected_option)
                dilal.cardEmail.setBackgroundResource(R.drawable.bg_unselected)


            }

            dilal.cardEmail.setOnClickListener {
                check=0
                dilal.checkWhatsapp.visibility = View.GONE
                dilal.checkEmail.visibility = View.VISIBLE
                dilal.cardEmail.setBackgroundResource(R.drawable.bg_selected_option)
                dilal.cardWhatsapp.setBackgroundResource(R.drawable.bg_unselected)
            }

            dialog.setContentView(dilal.root)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.show()
            dilal.btnContinue.setOnClickListener {
                dialog.cancel()
                when(check){
                    0-> findNavController().navigate(R.id.otp_fild2)
                    1-> findNavController().navigate(R.id.fragment_creat)
                }
            }



        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_password.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_password().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}