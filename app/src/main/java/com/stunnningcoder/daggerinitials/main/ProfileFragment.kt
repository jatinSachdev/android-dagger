package com.stunnningcoder.daggerinitials.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.stunnningcoder.daggerinitials.BR

import com.stunnningcoder.daggerinitials.R
import com.stunnningcoder.daggerinitials.ViewModelProvidersFactory
import com.stunnningcoder.daggerinitials.databinding.FragmentProfileBinding
import com.stunnningcoder.daggerinitials.login.User
import com.stunnningcoder.daggerinitials.network.NetworkResource
import dagger.android.support.DaggerFragment
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProfileFragment : DaggerFragment() {

    private lateinit var viewModel: ProfileFragmentViewModel

    private lateinit var mDataBinding: FragmentProfileBinding

    @set:Inject
    lateinit var viewModelProvidersFactory : ViewModelProvidersFactory

    lateinit var profileLiveData: LiveData<NetworkResource<User>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileLiveData = MutableLiveData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mDataBinding=  DataBindingUtil.inflate<FragmentProfileBinding>(LayoutInflater.from(activity), R.layout.fragment_profile, container, false)
        return mDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelProvidersFactory).get(ProfileFragmentViewModel::class.java)
        mDataBinding.setVariable(BR.profileViewModel, viewModel)
        viewModel.getCachedUser().removeObservers(viewLifecycleOwner)
        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, "Observing", Toast.LENGTH_SHORT).show()
        })
        viewModel.getCachedUser().observe(viewLifecycleOwner, Observer {
            when(it){
                is NetworkResource.Error -> {

                }
                is NetworkResource.Success -> {
                   viewModel.mutableLiveData.value = it.data
                }
            }

        })
        profileLiveData = viewModel.getCachedUser()
    }
}
