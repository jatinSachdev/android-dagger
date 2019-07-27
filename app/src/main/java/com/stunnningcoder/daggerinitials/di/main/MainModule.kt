package com.stunnningcoder.daggerinitials.di.main

import com.stunnningcoder.daggerinitials.main.MainApi
import com.stunnningcoder.daggerinitials.main.post.PostRecyclerViewAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Jatin on 7/21/19.
 */

@Module
class MainModule {

    @Module
    companion object{

        @MainScope
        @Provides
        @JvmStatic
        fun provideMainApi(retrofit: Retrofit): MainApi = retrofit.create(MainApi::class.java)

        @MainScope
        @Provides
        @JvmStatic
        fun providePostAdapter() : PostRecyclerViewAdapter{
            return PostRecyclerViewAdapter()
        }

    }
}