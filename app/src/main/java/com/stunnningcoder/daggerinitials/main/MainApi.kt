package com.stunnningcoder.daggerinitials.main

import com.stunnningcoder.daggerinitials.main.post.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jatin on 7/21/19.
 */
interface MainApi {

    @GET("posts")
    fun getUserPosts(@Query("userId") userId : Int) : Flowable<List<Post>>
}