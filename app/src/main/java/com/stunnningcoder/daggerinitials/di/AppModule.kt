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

/**
 * Created by Jatin on 7/11/19.
 */
@Module
class AppModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideRequestOptions(): RequestOptions {
            return RequestOptions.placeholderOf(R.drawable.login)
                .error(R.drawable.login)
        }

        @Provides
        @JvmStatic
        fun provideGlideManager(application: Application, requestOptions: RequestOptions): RequestManager {
            return Glide.with(application).setDefaultRequestOptions(requestOptions)
        }


        @Provides
        @JvmStatic
        fun provideAppDrawable(application: Application): Drawable? {
            return ContextCompat.getDrawable(application, R.drawable.login)
        }
    }


}