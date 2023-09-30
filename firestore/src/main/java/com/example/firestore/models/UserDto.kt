package com.example.firestore.models

import com.google.firebase.firestore.PropertyName

data class UserDto(
    @get:PropertyName("name")
    @set:PropertyName("name")
    var name: String? = null
)
