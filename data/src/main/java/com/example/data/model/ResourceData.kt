package com.example.data.model

sealed class ResourceData<out R> {

    data class Success<out R>(val result: R) : ResourceData<R>()
    data class Failure(val exception: Exception) : ResourceData<Nothing>()
}
