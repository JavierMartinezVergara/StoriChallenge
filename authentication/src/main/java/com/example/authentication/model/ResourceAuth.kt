package com.example.authentication.model

import com.example.authentication.R
import java.lang.Exception

sealed class ResourceAuth<out R> {
    data class Success<out R>(val result: R) : ResourceAuth<R>()
    data class Failure(val exception: Exception) : ResourceAuth<Nothing>()
}
