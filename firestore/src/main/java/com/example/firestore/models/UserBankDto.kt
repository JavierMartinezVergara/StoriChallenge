package com.example.firestore.models

data class UserBankDto(
    val name: String = "",
    val movements: MutableList<MovementDto> = mutableListOf()
)
