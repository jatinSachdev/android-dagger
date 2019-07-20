package com.stunnningcoder.daggerinitials.di

import android.app.Application
import com.stunnningcoder.daggerinitials.DagApplication
import com.stunnningcoder.daggerinitials.SessionManager
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Jatin on 6/29/19.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, AppModule::class, ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<DagApplication>{

    fun sessionManager() : SessionManager

    @Component.Builder
     interface Builder{

        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent

    }

}