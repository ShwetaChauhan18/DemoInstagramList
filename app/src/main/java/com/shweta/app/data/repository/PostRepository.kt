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
package com.shweta.app.data.repository

import com.shweta.app.data.remote.ApiService
import com.shweta.app.model.data.User
import com.shweta.app.model.response.PostResponse
import com.shweta.app.model.response.PostResponseItem
import com.shweta.app.utils.extension.response
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Singleton

interface PostRepository {
    /**
     * Loads [List] of [User]
     */
    suspend fun loadData(): ArrayList<PostResponseItem>
}

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PostRepository {
    override suspend fun loadData(): ArrayList<PostResponseItem> {
        return apiService.loadData().response()
    }
}
