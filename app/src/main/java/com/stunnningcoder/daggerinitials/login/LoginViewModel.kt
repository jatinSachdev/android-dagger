package com.stunnningcoder.daggerinitials.login

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.stunnningcoder.daggerinitials.SessionManager
import com.stunnningcoder.daggerinitials.network.NetworkResource
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Jatin on 7/13/19.
 */
const val TAG = "LoginViewModel"

class LoginViewModel @Inject constructor(val loginApi: LoginApi, val sessionManager: SessionManager) : ViewModel() , Observable{
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    init {
        Log.d(TAG, "Login ViewModel Injected")
        Log.d(TAG, loginApi.javaClass.toString())
    }

    fun authenticateUser(id : String?) {
       if(validateUserId(id)){
           id?.let { sessionManager.authenticateWithId(fetchUser(it)) }
       }
    }

    private fun validateUserId(id: String?) : Boolean {
        return if(!id.isNullOrBlank() && id.toIntOrNull() is Int){
            true
        }else{
            sessionManager.invalidLoginAttempt("Please enter valid id")
            false
        }
    }

    @Bindable
    var userIdLiveData  = MutableLiveData<String?>()


    fun fetchUser(id : String): LiveData<NetworkResource<User>> {
        return LiveDataReactiveStreams.fromPublisher(
             loginApi.getValidUser(id.toInt()).onErrorReturn { User().apply { this.id = -1 } }.map(object :
                Function<User, NetworkResource<User>> {
                override fun apply(t: User): NetworkResource<User> {

                    return if (t.id != -1) NetworkResource.Success(t) else NetworkResource.Error(message = "Something went wrong")
                }

            })
                .subscribeOn(Schedulers.io())
        )
    }

    fun observeUserSessionState(): LiveData<NetworkResource<User>> {
        return sessionManager.getCachedUser()
    }

}