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
package com.shweta.app.model.response

import com.google.gson.annotations.SerializedName
import com.shweta.app.model.data.User

class PostResponse : ArrayList<PostResponseItem>()

data class PostResponseItem(
    @SerializedName("blurImage")
    val blurImage: String,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("comments")
    val comments: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("posttype")
    val posttype: Int,
    @SerializedName("size")
    val size: String,
    @SerializedName("thumb")
    val thumb: String,
    @SerializedName("userImage")
    val userImage: String,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("width")
    val width: Int
)
