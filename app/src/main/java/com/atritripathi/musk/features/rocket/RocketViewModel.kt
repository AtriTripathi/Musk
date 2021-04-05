package com.atritripathi.musk.features.rocket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atritripathi.musk.data.model.Rocket
import com.atritripathi.musk.data.source.remote.RemoteApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(
    private val remoteApi: RemoteApi
) : ViewModel() {

    private val _rockets = MutableLiveData<List<Rocket>>()
    val rockets: LiveData<List<Rocket>> = _rockets

    init {
        viewModelScope.launch {
            _rockets.value = remoteApi.getRockets()
        }
    }
}