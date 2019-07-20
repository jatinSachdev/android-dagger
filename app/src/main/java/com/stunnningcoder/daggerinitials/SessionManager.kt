package com.stunnningcoder.daggerinitials

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.stunnningcoder.daggerinitials.login.User
import com.stunnningcoder.daggerinitials.network.NetworkResource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jatin on 7/18/19.
 */


@Singleton
class SessionManager @Inject constructor() {
    val TAG: String = "SessionManager"

    val cachedUser = MediatorLiveData<NetworkResource<User>>()

    fun authenticateWithId(userSource: LiveData<NetworkResource<User>>) {
        cachedUser.value = NetworkResource.Loading()
        cachedUser.addSource(userSource, { networkResourceUser ->
            cachedUser.value = networkResourceUser
            cachedUser.removeSource(userSource)
        })
    }

    fun getCachedUser(): LiveData<NetworkResource<User>> = cachedUser



    fun logout() {
        cachedUser.value = NetworkResource.Logout()
    }

    fun invalidLoginAttempt(message : String) {
        cachedUser.value = NetworkResource.Error(message = message)

    }

}