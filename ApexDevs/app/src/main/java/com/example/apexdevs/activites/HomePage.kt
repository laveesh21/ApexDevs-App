package com.example.apexdevs.activites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.apexdevs.R
import com.example.apexdevs.fragments.CommunityFragment
import com.example.apexdevs.fragments.MenuFragment
import com.example.apexdevs.fragments.ProjectsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomePage : AppCompatActivity() {

    lateinit var bottomNavBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        supportActionBar?.hide()

        val initialFragment = ProjectsFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, initialFragment).commit()

        bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavBar)
        supportActionBar?.title = "ApexDevs"

        // Set click listeners for bottom navigation items
        bottomNavBar.setOnNavigationItemSelectedListener{ menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(MenuFragment())
                    supportActionBar?.title = "ApexDevs"
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.community-> {
                    replaceFragment(CommunityFragment())
                    supportActionBar?.title = "Community"
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.upload -> {
                    replaceFragment(ProjectsFragment())
                    supportActionBar?.title = "Project Upload"
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

}