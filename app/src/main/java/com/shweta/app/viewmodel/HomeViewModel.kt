package com.shweta.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shweta.app.base.BaseViewModel
import com.shweta.app.data.repository.PostRepository
import com.shweta.app.model.response.PostResponseItem
import com.shweta.app.utils.result.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

@HiltViewModel
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) :
    BaseViewModel() {

    private val _onNewPostList = MutableLiveData<Event<List<PostResponseItem>>>()
    val onNewPostList: MutableLiveData<Event<List<PostResponseItem>>>
        get() = _onNewPostList


    init {
        loadPosts()
    }

    fun loadPosts() {

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                postRepository.loadData()
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    _onNewPostList.value = Event(it)
                }
            }.onFailure {
                Timber.e(it)
            }
        }
    }
}