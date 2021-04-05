package com.atritripathi.musk.features.rocket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.atritripathi.musk.data.MuskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(
    private val repository: MuskRepository
) : ViewModel() {

    val rockets = repository.getRockets().asLiveData()
}