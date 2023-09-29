package com.example.domain.models

sealed class ResponseStatus<T> {

    data class Success<T>(val data: T) : ResponseStatus<T>()

    data class Error<T>(val message: String) : ResponseStatus<T>()
}
