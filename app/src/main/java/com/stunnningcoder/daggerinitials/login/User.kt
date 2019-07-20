package com.stunnningcoder.daggerinitials.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Jatin on 7/14/19.
 */
class User {

    @SerializedName("id")
    @Expose
    var id: Int = 0

    @SerializedName("username")
    @Expose


    var username: String = ""

    @SerializedName("website")
    @Expose
    var website: String = ""

    @SerializedName("email")
    @Expose
    var email: String = ""
}