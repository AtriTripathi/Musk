package com.atritripathi.musk.features.crew

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.atritripathi.musk.R
import com.atritripathi.musk.data.model.Crew
import com.atritripathi.musk.databinding.CrewFragmentBinding
import com.atritripathi.musk.features.crew.CrewAdapter.OnCrewClickListener
import com.atritripathi.musk.util.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CrewFragment : Fragment(R.layout.crew_fragment), OnCrewClickListener {

    private val viewModel: CrewViewModel by viewModels()
    private var _binding: CrewFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = CrewFragmentBinding.bind(view)

        val crewAdapter = CrewAdapter(this)
        with(binding) {
            rvCrew.apply {
                adapter = crewAdapter
                setHasFixedSize(true)
            }
            PagerSnapHelper().attachToRecyclerView(rvCrew)
        }

        viewModel.crew.observe(viewLifecycleOwner) { result ->
            crewAdapter.submitList(result.data)
            with(binding) {
                loadingAnim.isVisible = result is Result.Loading && result.data.isNullOrEmpty()
                errorAnim.isVisible = result is Result.Error && result.data.isNullOrEmpty()
                tvError.isVisible = result is Result.Error && result.data.isNullOrEmpty()
                tvError.text = result.error?.localizedMessage
            }
        }
    }

    override fun onClick(crew: Crew) {
        val action = CrewFragmentDirections.actionGlobalWebViewFragment(crew.wikiUrl)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}