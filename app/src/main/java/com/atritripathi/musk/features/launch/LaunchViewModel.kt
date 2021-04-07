package com.atritripathi.musk.features.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.atritripathi.musk.data.MuskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val repository: MuskRepository
) : ViewModel() {
    val launches = repository.getLaunches().asLiveData()
}