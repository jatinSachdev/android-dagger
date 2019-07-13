package com.stunnningcoder.daggerinitials.login

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.RequestManager
import com.stunnningcoder.daggerinitials.R
import com.stunnningcoder.daggerinitials.ViewModelProvidersFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

    @set:Inject
    var daggerString : String = ""

    @set:Inject
    var requestManager: RequestManager? = null

    @set:Inject
    var loginDrawable : Drawable? = null

    var loginViewModel : LoginViewModel ? = null

    @set:Inject
    lateinit var viewModelProvidersFactory :ViewModelProvidersFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(this.javaClass.canonicalName, daggerString)
        setLogo()
        loginViewModel = ViewModelProviders.of(this, viewModelProvidersFactory).get(LoginViewModel::class.java)
        val button = Button(this)
        button.setOnClickListener {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    private fun setLogo() {
        requestManager?.load(loginDrawable)?.into(findViewById(R.id.ivLogin))
    }
}
