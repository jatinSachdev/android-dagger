package com.stunnningcoder.daggerinitials.network

/**
 * Created by Jatin on 7/17/19.
 */
sealed class NetworkResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : NetworkResource<T>(data)
    class Loading<T>(data: T? = null) : NetworkResource<T>(data)
    class Error<T>(data: T? = null, message: String) : NetworkResource<T>(data)
    class Logout<T>() : NetworkResource<T>()
}