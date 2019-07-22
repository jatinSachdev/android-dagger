package com.stunnningcoder.daggerinitials.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.stunnningcoder.daggerinitials.BaseActivity
import com.stunnningcoder.daggerinitials.R
import com.stunnningcoder.daggerinitials.main.post.PostsFragment
import com.stunnningcoder.daggerinitials.main.profile.ProfileFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inflateProfile()
    }

    private fun inflateProfile() {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer,
            PostsFragment()
        ).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.logout ->{
                sessionManager.logout()
                return true
            }
        }
        return false
    }
}

