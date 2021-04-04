package com.atritripathi.musk.rocket

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atritripathi.musk.R
import com.atritripathi.musk.databinding.RocketFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketFragment : Fragment(R.layout.rocket_fragment) {

    private val viewModel: RocketViewModel by viewModels()

    private var _binding: RocketFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = RocketFragmentBinding.bind(view)

        val rocketAdapter = RocketAdapter()
        with(binding) {
            rvRocket.apply {
                adapter = rocketAdapter
                setHasFixedSize(true)
            }
        }

        viewModel.rockets.observe(viewLifecycleOwner) { rockets ->
            rocketAdapter.submitList(rockets)
        }
    }
}