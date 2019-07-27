package com.stunnningcoder.daggerinitials.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.stunnningcoder.daggerinitials.BaseActivity
import com.stunnningcoder.daggerinitials.R
import com.stunnningcoder.daggerinitials.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var controller: NavController
    lateinit var mainBinding: ActivityMainBinding
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        mainBinding.drawerLayout.closeDrawer(GravityCompat.START)
        item.isChecked = true
        if (controller.currentDestination?.label == item.title) {
            return true
        }
        when (item.itemId) {
            R.id.navProfile -> {
                controller.navigate(R.id.action_profileFragment_pop)
            }
            R.id.navPosts -> {

                controller.navigate(R.id.postFragment)
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpNavigationController()
    }

    private fun setUpNavigationController() {
        controller = Navigation.findNavController(this, R.id.navHostMain)
        NavigationUI.setupActionBarWithNavController(this, controller, mainBinding.drawerLayout)
        NavigationUI.setupWithNavController(mainBinding.navView, controller)
        mainBinding.navView.setNavigationItemSelectedListener(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                } else {
                    false
                }
            }
            R.id.logout -> {
                sessionManager.logout()
                true
            }
            else -> false
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        NavigationUI.navigateUp(controller, drawerLayout)
        return super.onSupportNavigateUp()
    }
}

