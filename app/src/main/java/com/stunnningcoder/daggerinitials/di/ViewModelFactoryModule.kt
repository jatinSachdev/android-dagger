package com.stunnningcoder.daggerinitials.di

import androidx.lifecycle.ViewModelProvider
import com.stunnningcoder.daggerinitials.ViewModelProvidersFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Jatin on 7/13/19.
 */
@Module
@Suppress("Dagger Abstraction")
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProvidersFactory: ViewModelProvidersFactory) : ViewModelProvider.Factory
}