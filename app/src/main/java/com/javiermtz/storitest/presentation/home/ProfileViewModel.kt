package com.javiermtz.storitest.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ResponseStatus
import com.example.domain.usecases.ProfileGetDataUseCase
import com.javiermtz.storitest.presentation.utils.SaveableComposeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileInfoUseCase: ProfileGetDataUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _profileInfo = mutableStateOf<StateDashboard>(StateDashboard.Loading)
    val profileInfo = _profileInfo

    private var uuidStateHandle by SaveableComposeState(
        savedStateHandle = savedStateHandle,
        key = "uuid",
        defaultValue = ""
    )

    init {
        getProfileInfo()
    }

    private fun getProfileInfo() {
        viewModelScope.launch {
            profileInfo.value = StateDashboard.Loading
            getProfileInfoUseCase(uuidStateHandle)
                .collect {
                    when (val data = it) {
                        is ResponseStatus.Error -> {
                            profileInfo.value = StateDashboard.Error(data.message)
                        }

                        is ResponseStatus.Success -> profileInfo.value = StateDashboard.Success(data.data)
                    }
                }
        }
    }
}
