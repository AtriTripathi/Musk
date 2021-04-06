package com.atritripathi.musk.features.crew

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.atritripathi.musk.data.MuskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CrewViewModel @Inject constructor(
    private val repository: MuskRepository
) : ViewModel() {
    val crew = repository.getCrew().asLiveData()
}