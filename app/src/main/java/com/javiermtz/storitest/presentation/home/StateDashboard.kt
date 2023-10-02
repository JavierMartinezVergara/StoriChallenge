package com.javiermtz.storitest.presentation.home

import com.example.domain.models.ProfileData

sealed class StateDashboard {
    object Loading : StateDashboard()
    data class Success(val data: ProfileData) : StateDashboard()
    object Empty : StateDashboard()
    data class Error(val message: String) : StateDashboard()
}
