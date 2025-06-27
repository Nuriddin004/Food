package com.example.food.Fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.food.R
import com.example.food.adapter.mypageradapter_onboarding
import com.example.food.models.Mypager


class Fragment_1 : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: mypageradapter_onboarding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        viewPager = view.findViewById(R.id.fragment_viewpager)

        val list = listOf<Mypager>(
            Mypager(R.drawable.onbording_1, "We serve incomparable delicacies", "All the best restaurants with their top \n menu waiting for you, they cant’t wait\n  for your order!!"),

            Mypager(R.drawable.onbording_2, "We serve incomparable delicacies", "All the best restaurants with their top\n menu waiting for you, they cant’t wait\n for your order!!"),

            Mypager(R.drawable.onbording_2, "We serve incomparable delicacies", "All the best restaurants with their top\n menu waiting for you, they cant’t wait \nfor your order!!")
        )

        adapter = mypageradapter_onboarding(list)
        viewPager.adapter = adapter

        return view
    }
}