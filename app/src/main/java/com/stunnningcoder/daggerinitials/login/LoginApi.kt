package com.stunnningcoder.daggerinitials.login

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Jatin on 7/14/19.
 */
interface LoginApi {

    @GET("users/{id}")
    fun getValidUser(@Path("id")id : Int): Flowable<User>
}