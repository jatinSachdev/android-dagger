package com.stunnningcoder.daggerinitials.main.post

import androidx.lifecycle.*
import com.stunnningcoder.daggerinitials.SessionManager
import com.stunnningcoder.daggerinitials.main.MainApi
import com.stunnningcoder.daggerinitials.network.NetworkResource
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Jatin on 7/21/19.
 */
class  PostsFragmentViewModel @Inject constructor(val sessionManager: SessionManager, val mainApi: MainApi)  :ViewModel(){

    var mediatorLiveData : MediatorLiveData<NetworkResource<List<Post>>> = MediatorLiveData()

    fun fetchPosts() {
        val id = sessionManager.cachedUser.value?.data?.id
        var liveData : LiveData<NetworkResource<List<Post>>> = MutableLiveData<NetworkResource<List<Post>>>()
        id?.let {    liveData = LiveDataReactiveStreams.fromPublisher(mainApi.getUserPosts(id).onErrorReturn({
          mutableListOf()
        }).map {
            if(it.isEmpty()) {
                NetworkResource.Error<List<Post>>(message = "Unable to fetch Posts")
            }else{
                NetworkResource.Success(it)
            }
        }.subscribeOn(Schedulers.io()))

        }
        (mediatorLiveData).addSource(liveData, {
            (mediatorLiveData).value = it
            (mediatorLiveData).removeSource(liveData)
        })
    }

    fun observePosts() : LiveData<NetworkResource<List<Post>>> = mediatorLiveData
}