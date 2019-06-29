package com.stunnningcoder.daggerinitials

import com.stunnningcoder.daggerinitials.di.AppComponent
import com.stunnningcoder.daggerinitials.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Jatin on 6/29/19.
 */
class DagApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerAppComponent.builder().application(this).build()
    }
}