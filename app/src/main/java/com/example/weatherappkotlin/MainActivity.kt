package com.example.weatherappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.weatherappkotlin.ui.ListFragment
import com.example.weatherappkotlin.ui.MainFragment
import com.example.weatherappkotlin.ui.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView.setOnNavigationItemSelectedListener (mOnNavitagionItemSelectedListener)
        loadFragment(MainFragment())
    }

    private val mOnNavitagionItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.nav_map -> loadFragment(MainFragment())
            R.id.nav_list -> loadFragment(ListFragment())
            R.id.nav_profile -> loadFragment(ProfileFragment())
        }
        return@OnNavigationItemSelectedListener true
    }



    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
