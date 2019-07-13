package com.stunnningcoder.daggerinitials.di.login

import androidx.lifecycle.ViewModel
import com.stunnningcoder.daggerinitials.di.ViewModelKey
import com.stunnningcoder.daggerinitials.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Jatin on 7/13/19.
 */
@Module
abstract class LoginViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun loginViewModel(loginViewModel: LoginViewModel) : ViewModel
}