package com.example.encare.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.encare.fragments.*

class ViewPagerMainAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position){
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return AppointmentsFragment()
            }
            2 -> {
                return MessageFragment()
            }
            3 -> {
                return ProfileFragment()
            }else -> {
                return HomeFragment()
            }
        }
    }
}