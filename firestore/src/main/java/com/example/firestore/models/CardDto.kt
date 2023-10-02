package com.example.firestore.models

import com.google.firebase.firestore.PropertyName

data class CardDto(
    @get:PropertyName("accountNumber")
    @set:PropertyName("accountNumber")
    var accountNumber: String? = null,
    @get:PropertyName("amount")
    @set:PropertyName("amount")
    var amount: String? = null,
    @get:PropertyName("cardNumber")
    @set:PropertyName("cardNumber")
    var cardNumber: String? = null,
    @get:PropertyName("type")
    @set:PropertyName("type")
    var type: String? = null
)
