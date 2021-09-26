/*
* Copyright 2021 DemoInstragram
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.shweta.app.ui.adapter

import android.net.Uri
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.shweta.app.R
import com.shweta.app.base.BaseRecyclerAdapter
import com.shweta.app.model.response.PostResponseItem

class PostAdapter : BaseRecyclerAdapter<PostResponseItem>() {
    override fun getLayoutIdForType(viewType: Int): Int = R.layout.item_user

    override fun onItemClick(view: View?, adapterPosition: Int) {
        when(view?.id) {
            R.id.videoView -> {
                playVideo(view, arrayList[adapterPosition])
            }
        }
    }

    override fun areItemsSame(oldItem: PostResponseItem, newItem: PostResponseItem): Boolean {
        return oldItem == newItem
    }

    private fun playVideo(view: View?, postResponseItem: PostResponseItem) {
        if (postResponseItem.posttype == 2) {
            (view as VideoView).apply {
                setVideoURI(Uri.parse(postResponseItem.content))
                val mediaController = MediaController(view.context)
                mediaController.setAnchorView(this)
                mediaController.setMediaPlayer(this)
                setMediaController(mediaController)
                start()
            }
        }
    }
}
