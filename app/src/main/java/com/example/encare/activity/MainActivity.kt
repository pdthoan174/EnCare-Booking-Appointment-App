package com.example.encare.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.viewpager2.widget.ViewPager2
import com.example.encare.*
import com.example.encare.adapters.ViewPagerMainAdapter
import com.example.encare.fragments.AppointmentsFragment
import com.example.encare.fragments.HomeFragment
import com.example.encare.fragments.MessageFragment
import com.example.encare.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewPagerAdapter = ViewPagerMainAdapter(this)
        // add 4 fragments vao ViewPager
        view_pager_2.adapter = viewPagerAdapter

        // Khi bam vao cac item trong bottom_navigation
        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.nav_home -> {
                    view_pager_2.currentItem = 0
                }
                R.id.nav_appointment -> {
                    view_pager_2.currentItem = 1
                }
                R.id.nav_message -> {
                    view_pager_2.currentItem = 2
                }
                R.id.nav_profile -> {
                    view_pager_2.currentItem = 3
                }
            }
            true
        }

        // khi scroll tren man hinh
        view_pager_2.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> {
                        bottom_navigation.menu.findItem(R.id.nav_home).isChecked = true
                    }
                    1 -> {
                        bottom_navigation.menu.findItem(R.id.nav_appointment).isChecked = true
                    }
                    2 -> {
                        bottom_navigation.menu.findItem(R.id.nav_message).isChecked = true
                    }
                    3 -> {
                        bottom_navigation.menu.findItem(R.id.nav_profile).isChecked = true
                    }
                }
            }
        })
    }

}