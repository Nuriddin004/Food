package com.example.food.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.food.R
import com.example.food.models.Mypager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class mypageradapter_onboarding(
    private val list: List<Mypager>,
    private val viewPager: ViewPager2
) : RecyclerView.Adapter<mypageradapter_onboarding.ViewHolder>() {

    var currentPageIndex = 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.findViewById(R.id.titleText)
        val descText: TextView = view.findViewById(R.id.descText)
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout_inner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.titleText.text = item.title
        holder.descText.text = item.info
        holder.itemView.setBackgroundResource(item.image)

        // Faqat birinchi sahifada indicator ko‘rsatamiz
        if (position == 0) {
            holder.tabLayout.visibility = View.VISIBLE
            TabLayoutMediator(holder.tabLayout, viewPager) { tab, pos ->
                val iconRes = if (pos == currentPageIndex)
                    R.drawable.icon2
                else
                    R.drawable.iconindicator
                tab.setIcon(iconRes)
            }.attach()
        } else {
            holder.tabLayout.visibility = View.GONE
        }
    }
}
