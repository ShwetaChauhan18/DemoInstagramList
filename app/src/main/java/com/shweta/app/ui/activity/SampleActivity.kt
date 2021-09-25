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
package com.shweta.app.ui.activity

import androidx.activity.viewModels
import com.shweta.app.R
import com.shweta.app.base.BaseAppCompatActivity
import com.shweta.app.databinding.ActivitySampleBinding
import com.shweta.app.viewmodel.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : BaseAppCompatActivity<ActivitySampleBinding, SampleViewModel>() {
    override val viewModel: SampleViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_sample

    override fun initialize() {
        super.initialize()
    }

    override fun initializeObservers(viewModel: SampleViewModel) {
        super.initializeObservers(viewModel)
    }
}
