package com.shweta.app.ui.fragment

import androidx.fragment.app.viewModels
import com.shweta.app.R
import com.shweta.app.base.BaseFragment
import com.shweta.app.databinding.FragmentNewsBinding
import com.shweta.app.viewmodel.NewsViewModel

class NewsFragment : BaseFragment<FragmentNewsBinding, NewsViewModel>() {

    override val viewModel: NewsViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.fragment_news
}