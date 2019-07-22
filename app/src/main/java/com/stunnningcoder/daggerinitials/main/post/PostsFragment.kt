package com.stunnningcoder.daggerinitials.main.post


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.stunnningcoder.daggerinitials.R
import com.stunnningcoder.daggerinitials.ViewModelProvidersFactory
import com.stunnningcoder.daggerinitials.databinding.FragmentPostsBinding
import com.stunnningcoder.daggerinitials.network.NetworkResource
import dagger.android.support.DaggerFragment
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 *
 */
class PostsFragment : DaggerFragment() {

    lateinit var viewModel: PostsFragmentViewModel

    lateinit var mBinding: FragmentPostsBinding

    @set:Inject
    lateinit var mPostRecyclerViewAdapter: PostRecyclerViewAdapter

    @set:Inject
    lateinit var viewModelProvidersFactory: ViewModelProvidersFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.fragment_posts, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelProvidersFactory).get(PostsFragmentViewModel::class.java)
        viewModel.fetchPosts()
        viewModel.observePosts().removeObservers(viewLifecycleOwner)
        viewModel.observePosts().observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResource.Success->{
                    it.data?.let {list ->
                        mPostRecyclerViewAdapter.posts = list
                        initPostsRecycler()
                    }

                }
                is NetworkResource.Error-> {

                }
            }
        })

    }

    private fun initPostsRecycler() {
        mBinding.rvPosts.adapter = mPostRecyclerViewAdapter
        mBinding.rvPosts.layoutManager = LinearLayoutManager(context)
    }
}
