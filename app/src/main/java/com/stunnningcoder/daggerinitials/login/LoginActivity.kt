package com.stunnningcoder.daggerinitials.login

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.stunnningcoder.daggerinitials.BR
import com.stunnningcoder.daggerinitials.MainActivity
import com.stunnningcoder.daggerinitials.R
import com.stunnningcoder.daggerinitials.ViewModelProvidersFactory
import com.stunnningcoder.daggerinitials.databinding.ActivityLoginBinding
import com.stunnningcoder.daggerinitials.network.NetworkResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @set:Inject
    var daggerString : String = ""

    @set:Inject
    var requestManager: RequestManager? = null

    @set:Inject
    var loginDrawable : Drawable? = null

    lateinit var loginViewModel : LoginViewModel

    @set:Inject
    lateinit var viewModelProvidersFactory :ViewModelProvidersFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityLoginBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        Log.d(this.javaClass.canonicalName, daggerString)
        setLogo()
        loginViewModel = ViewModelProviders.of(this, viewModelProvidersFactory).get(LoginViewModel::class.java)
        loginViewModel.observeUserSessionState().observe(this, Observer {
            when(it){
                is NetworkResource.Loading -> {
                    activityLoginBinding.progress.visibility = View.VISIBLE
                }
                is NetworkResource.Error -> {
                    activityLoginBinding.progress.visibility = View.GONE
                    Toast.makeText(this, "FAILURE", Toast.LENGTH_LONG).show()
                }
                is NetworkResource.Success -> {
                    activityLoginBinding.progress.visibility = View.GONE
                    invadeDagger()
                    Toast.makeText(this, (it.data?.username) + "SUCCESS", Toast.LENGTH_LONG).show()

                }
            }
        })
        activityLoginBinding.setVariable(BR.loginViewModel, loginViewModel)
    }

    private fun invadeDagger() {
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        startActivity(mainActivityIntent)
        finish()
    }

    private fun setLogo() {
        requestManager?.load(loginDrawable)?.into(findViewById(R.id.ivLogin))
    }
}
