package com.stunnningcoder.daggerinitials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.stunnningcoder.daggerinitials.login.LoginActivity
import com.stunnningcoder.daggerinitials.network.NetworkResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class  BaseActivity : DaggerAppCompatActivity() {

    @set:Inject
    lateinit var sessionManager : SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        sessionManager.getCachedUser().observe(this, Observer {
            when(it){
                is NetworkResource.Loading -> {

                }
                is NetworkResource.Error -> {

                    Toast.makeText(this, "FAILURE", Toast.LENGTH_LONG).show()
                }
                is NetworkResource.Success -> {

                }
                is NetworkResource.Logout -> {
                    logout()
                }
            }

        })
    }

    private fun logout() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
