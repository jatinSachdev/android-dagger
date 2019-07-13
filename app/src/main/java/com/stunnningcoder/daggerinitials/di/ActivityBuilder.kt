package com.stunnningcoder.daggerinitials.di

import com.stunnningcoder.daggerinitials.di.login.LoginViewModelsModule
import com.stunnningcoder.daggerinitials.login.LoginActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by Jatin on 6/29/19.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [LoginViewModelsModule::class])
    abstract fun getLoginActivity(): LoginActivity

    @Module
    companion object{
        @JvmStatic @Provides
        fun injectedString(): String {
            return "Dagger is here for DI"
        }
    }


}