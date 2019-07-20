package com.stunnningcoder.daggerinitials.di

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.stunnningcoder.daggerinitials.R
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Jatin on 7/11/19.
 */

const val baseUrl = "https://jsonplaceholder.typicode.com/"
@Module
class AppModule {

    @Module
    companion object {
        @Singleton
        @Provides
        @JvmStatic
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions.placeholderOf(R.drawable.login)
                .error(R.drawable.login)
        }
        @Singleton
        @Provides
        @JvmStatic
        fun provideGlideManager(application: Application, requestOptions: RequestOptions): RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions)
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideRetrofitInstance() : Retrofit{
            return Retrofit.Builder().baseUrl(baseUrl).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideAppDrawable(application: Application): Drawable? {
            return ContextCompat.getDrawable(application, R.drawable.login)
        }
    }


}