package com.stunnningcoder.daggerinitials.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stunnningcoder.daggerinitials.SessionManager
import com.stunnningcoder.daggerinitials.login.User
import com.stunnningcoder.daggerinitials.network.NetworkResource
import javax.inject.Inject

/**
 * Created by Jatin on 7/21/19.
 */
const val TAG = "ProfileViewModel"
class ProfileFragmentViewModel @Inject constructor(val sessionManager: SessionManager) : ViewModel() {

    val mutableLiveData = MutableLiveData<User>()

    init {
        Log.d(TAG, "Created")

    }




    fun getCachedUser() : LiveData<NetworkResource<User>> = sessionManager.getCachedUser()

}