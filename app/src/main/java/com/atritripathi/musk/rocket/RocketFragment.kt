package com.atritripathi.musk.rocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.atritripathi.musk.R

class RocketFragment : Fragment(R.layout.rocket_fragment) {

    private val viewModel: RocketViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}