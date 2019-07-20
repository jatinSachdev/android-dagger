package com.stunnningcoder.daggerinitials.di.login

import com.stunnningcoder.daggerinitials.login.LoginApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Jatin on 7/14/19.
 */
@Module
class LoginModule {

    @Module
    companion object{

        @Provides
        @JvmStatic
        fun provideLoginApi(retrofit: Retrofit) : LoginApi {
            return retrofit.create(LoginApi::class.java)
        }
    }
}