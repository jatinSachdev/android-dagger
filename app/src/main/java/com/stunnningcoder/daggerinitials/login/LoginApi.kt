package com.stunnningcoder.daggerinitials.login

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Jatin on 7/14/19.
 */
interface LoginApi {

    @GET
    fun getValidUser(): Call<ResponseBody>
}