package com.example.food.Fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.food.R
import com.example.food.adapter.mypageradapter_onboarding
import com.example.food.databinding.Fragment1Binding
import com.example.food.models.Mypager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Fragment_1 : Fragment() {

private val binding by lazy { Fragment1Binding.inflate(layoutInflater) }

    private lateinit var adapter: mypageradapter_onboarding
    private val iconSelected = R.drawable.iconindicator
    private val iconUnselected = R.drawable.icon2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val list = listOf(
            Mypager(
                R.drawable.onbording_1, "We serve incomparable delicacies",
                "All the best restaurants with their top\nmenu waiting for you, they can't wait for your order!!"
            ),
            Mypager(
                R.drawable.onbording_2, "Fast delivery to your home",
                "We deliver food from your favorite restaurants to your doorstep in minutes."
            ),
            Mypager(
                R.drawable.onbording_2, "Enjoy your meal",
                "Sit back and enjoy your delicious food at home!"
            )
        )

        adapter = mypageradapter_onboarding(list)
        binding.fragmentViewpager.adapter = adapter

        // TabLayoutMediator bilan icon qo‘yish
        TabLayoutMediator(binding.tabLayoutInner, binding.fragmentViewpager) { tab, _ ->
            tab.setIcon(iconUnselected)
        }.attach()

        // Iconlarni yangilash
        binding.fragmentViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in 0 until binding.tabLayoutInner.tabCount) {
                    val tab = binding.tabLayoutInner.getTabAt(i)
                    tab?.setIcon(if (i == position) iconSelected else iconUnselected)
                }

                // Tugmalar holatini o‘zgartirish
                if (position == list.size - 1) {
                    binding.skipText.visibility = View.GONE
                    binding.nextText.visibility = View.GONE
                    binding.fab.visibility = View.VISIBLE
                } else {
                    binding.skipText.visibility = View.VISIBLE
                    binding.nextText.visibility = View.VISIBLE
                    binding.fab.visibility = View.GONE
                }
            }
        })

        // Tugmalar
        binding.skipText.setOnClickListener {
            binding.fragmentViewpager.currentItem = list.size - 1
        }

        binding.nextText.setOnClickListener {
            val nextPage = binding.fragmentViewpager.currentItem + 1
            if (nextPage < list.size) {
                binding.fragmentViewpager.currentItem = nextPage
            }
        }

        return binding.root
    }


}

