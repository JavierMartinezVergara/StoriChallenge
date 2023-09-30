package com.example.firestore.models

import java.lang.Exception

sealed class ResourceFireStore<out R> {
    data class Success<out R>(val result: R) : ResourceFireStore<R>()
    data class Failure(val exception: Exception) : ResourceFireStore<Nothing>()
}
