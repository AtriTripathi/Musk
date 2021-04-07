package com.atritripathi.musk.features.launch

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atritripathi.musk.R
import com.atritripathi.musk.databinding.LaunchFragmentBinding
import com.atritripathi.musk.util.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchFragment : Fragment(R.layout.launch_fragment) {

    private val viewModel: LaunchViewModel by viewModels()
    private var _binding: LaunchFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = LaunchFragmentBinding.bind(view)

        val launchAdapter = LaunchAdapter()
        with(binding) {
            rvLaunch.apply {
                adapter = launchAdapter
                setHasFixedSize(true)
            }
        }

        viewModel.launches.observe(viewLifecycleOwner) { result ->
            launchAdapter.submitList(result.data)
            with(binding) {
                loadingAnim.isVisible = result is Result.Loading && result.data.isNullOrEmpty()
                errorAnim.isVisible = result is Result.Error && result.data.isNullOrEmpty()
                tvError.isVisible = result is Result.Error && result.data.isNullOrEmpty()
                tvError.text = result.error?.localizedMessage
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}