package com.stunnningcoder.daggerinitials.di.main

import com.stunnningcoder.daggerinitials.main.post.PostsFragment
import com.stunnningcoder.daggerinitials.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Jatin on 7/21/19.
 */

@Module
abstract class MainActivityFragmentsBuilderModule{

    @ContributesAndroidInjector
    abstract fun contributesProfileFragment() : ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributesPostsFragment() : PostsFragment

}