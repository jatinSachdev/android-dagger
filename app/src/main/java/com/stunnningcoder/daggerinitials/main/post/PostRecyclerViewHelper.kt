package com.stunnningcoder.daggerinitials.main.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.stunnningcoder.daggerinitials.R
import com.stunnningcoder.daggerinitials.databinding.RvItemPostsLayoutBinding

/**
 * Created by Jatin on 7/21/19.
 */
class PostRecyclerViewAdapter : RecyclerView.Adapter<PostRecyclerViewHolder>() {

    lateinit var posts : List<Post>

    lateinit var mBinding: RvItemPostsLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostRecyclerViewHolder {
      mBinding = DataBindingUtil.inflate<RvItemPostsLayoutBinding>(LayoutInflater.from(parent.context), R.layout.rv_item_posts_layout, parent, false)
      return PostRecyclerViewHolder(mBinding.root)

    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostRecyclerViewHolder, position: Int) {
        mBinding.posts = posts[position]
    }
}

class PostRecyclerViewHolder(view : View) : RecyclerView.ViewHolder(view){
}