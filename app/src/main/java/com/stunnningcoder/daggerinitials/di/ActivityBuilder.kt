package com.stunnningcoder.daggerinitials.di

import com.stunnningcoder.daggerinitials.main.MainActivity
import com.stunnningcoder.daggerinitials.di.login.LoginViewModelsModule
import com.stunnningcoder.daggerinitials.login.LoginActivity
import com.stunnningcoder.daggerinitials.di.login.LoginModule
import com.stunnningcoder.daggerinitials.di.login.LoginScope
import com.stunnningcoder.daggerinitials.di.main.MainActivityFragmentsBuilderModule
import com.stunnningcoder.daggerinitials.di.main.MainModule
import com.stunnningcoder.daggerinitials.di.main.MainScope
import com.stunnningcoder.daggerinitials.di.main.MainViewModelModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by Jatin on 6/29/19.
 */

@Module
abstract class ActivityBuilder {

    @LoginScope
    @ContributesAndroidInjector(modules = [LoginViewModelsModule::class, LoginModule::class])
    abstract fun getLoginActivity(): LoginActivity


    @MainScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentsBuilderModule::class, MainViewModelModule::class, MainModule::class])
    abstract fun getMainActivity(): MainActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun injectedString(): String {
            return "Dagger is here for DI"
        }
    }
}