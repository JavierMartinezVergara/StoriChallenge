package com.example.domain.mappers

import com.example.domain.models.UserData
import com.example.firestore.models.UserDto

fun UserData.toUserDto() : UserDto {
  return UserDto(name)
}
