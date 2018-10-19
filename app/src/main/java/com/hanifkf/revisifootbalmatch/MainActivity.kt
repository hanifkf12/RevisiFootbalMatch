package com.hanifkf.revisifootbalmatch

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(PrevFragment(), savedInstanceState)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_prev -> {
                    loadFragment(PrevFragment(), savedInstanceState)

                }
                R.id.nav_next -> {
                    loadFragment(NextFragment(), savedInstanceState)

                }
                R.id.nav_fav -> {
                    loadFragment(FavoriteFragment(), savedInstanceState)

                }
            }
            false
        }
    }

    private fun loadFragment(fragment : Fragment, savedInstanceState: Bundle?){
        if(savedInstanceState==null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container,fragment,fragment::class.java.simpleName)
                .commit()
        }
    }
}
