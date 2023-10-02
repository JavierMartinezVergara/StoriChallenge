package com.example.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovementData(
    val account: String = "",
    val amount: String = "",
    val concept: String = "",
    val date: String = "",
    val hour: String = ""
) : Parcelable
