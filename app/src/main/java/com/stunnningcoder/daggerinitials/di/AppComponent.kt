package com.stunnningcoder.daggerinitials.di

import android.app.Application
import com.stunnningcoder.daggerinitials.DagApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Jatin on 6/29/19.
 */
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<DagApplication> {

    @Component.Builder
     interface Builder{

        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent

    }

}