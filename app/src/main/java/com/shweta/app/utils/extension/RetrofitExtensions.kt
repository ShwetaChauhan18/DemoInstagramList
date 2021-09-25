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
package com.shweta.app.utils.extension

import com.google.gson.Gson
import com.shweta.app.base.BaseResponse
import retrofit2.HttpException
import retrofit2.Response

const val BAD_REQUEST_CODE = 400

/**
 * Converts [retrofit2.Response] to body response and
 * handles [BAD_REQUEST_CODE] which returns body response.
 *
 * Provides response if [Response.isSuccessful] or [BAD_REQUEST_CODE].
 * Throws [HttpException] if error is above 400.
 */
inline fun <reified R> Response<R>.response(): R =
    if (isSuccessful) {
        body()!!
    } else {
        if (code() == BAD_REQUEST_CODE) {
            Gson().fromJson(errorBody()?.string(), R::class.java)
        } else {
            throw HttpException(this)
        }
    }
