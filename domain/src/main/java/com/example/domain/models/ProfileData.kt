package com.example.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileData(
    val name: String = "",
    val movements: List<MovementData>
) : Parcelable
