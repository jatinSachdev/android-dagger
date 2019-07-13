package com.stunnningcoder.daggerinitials.login

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Jatin on 7/13/19.
 */
const val TAG = "LoginViewModel"
class LoginViewModel @Inject constructor() : ViewModel(){
    init {
        Log.d(TAG, "Login ViewModel Injected")
    }

}