package com.stunnningcoder.daggerinitials.di.main

import androidx.lifecycle.ViewModel
import com.stunnningcoder.daggerinitials.di.ViewModelKey
import com.stunnningcoder.daggerinitials.main.post.PostsFragmentViewModel
import com.stunnningcoder.daggerinitials.main.profile.ProfileFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Jatin on 7/21/19.
 */

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel::class)
    abstract fun bindProfileViewModel(profileFragmentViewModel: ProfileFragmentViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(PostsFragmentViewModel::class)
    abstract fun bindPostsViewModel(postsFragmentViewModel: PostsFragmentViewModel) : ViewModel

}