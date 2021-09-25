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

import android.view.View
import com.shweta.app.R
import com.shweta.app.base.BaseRecyclerAdapter
import com.shweta.app.model.response.PostResponseItem

class PostAdapter : BaseRecyclerAdapter<PostResponseItem>() {
    override fun getLayoutIdForType(viewType: Int): Int = R.layout.item_user

    override fun onItemClick(view: View?, adapterPosition: Int) {
        /* no-op */
    }

    override fun areItemsSame(oldItem: PostResponseItem, newItem: PostResponseItem): Boolean {
        return oldItem == newItem
    }

}
