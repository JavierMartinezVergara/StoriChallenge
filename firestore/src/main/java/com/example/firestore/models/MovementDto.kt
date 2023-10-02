package com.example.firestore.models

import com.google.firebase.firestore.PropertyName

data class MovementDto(
    @get:PropertyName("account")
    @set:PropertyName("account")
    var account: String = "",
    @get:PropertyName("amount")
    @set:PropertyName("amount")
    var amount: String = "",
    @get:PropertyName("concept")
    @set:PropertyName("concept")
    var concept: String = "",
    @get:PropertyName("date")
    @set:PropertyName("date")
    var date: String = "",
    @get:PropertyName("hour")
    @set:PropertyName("hour")
    var hour: String = ""
)
