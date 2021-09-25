package com.shweta.app.ui.fragment

import androidx.fragment.app.viewModels
import com.shweta.app.R
import com.shweta.app.base.BaseFragment
import com.shweta.app.databinding.FragmentHomeBinding
import com.shweta.app.ui.adapter.PostAdapter
import com.shweta.app.utils.extension.observeEvent
import com.shweta.app.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val postAdapter = PostAdapter()

    override val viewModel: HomeViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initialize() {
        super.initialize()
        setRecyclerView()
    }

    override fun initializeObservers(viewModel: HomeViewModel) {
        super.initializeObservers(viewModel)
        viewModel.onNewPostList.observeEvent(this) {
            postAdapter.addAllItem(it)
        }
    }

    private fun setRecyclerView() {
        binding.rvUsers.adapter = postAdapter
    }
}
