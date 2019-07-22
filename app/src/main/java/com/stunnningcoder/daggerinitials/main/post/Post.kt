package com.stunnningcoder.daggerinitials.main.post

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Jatin on 7/21/19.
 */
data class Post(
    @SerializedName("id") @Expose() val id: Int,
    @SerializedName("userId") @Expose() val userId: String,
    @SerializedName("title") @Expose() val title: String,
    @SerializedName("body") @Expose() val body: String
)
