package com.example.domain.mappers

import com.example.domain.models.MovementData
import com.example.domain.models.ProfileData
import com.example.domain.models.UserData
import com.example.firestore.models.UserBankDto
import com.example.firestore.models.UserDto

fun UserData.toUserDto() : UserDto {
  return UserDto(name)
}

fun UserBankDto.toProfileData() : ProfileData{

  return ProfileData(
    name = name,
    movements = movements.map {
      MovementData(
        account = it.account,
        amount = it.amount,
        concept = it.concept,
        date = it.date,
        hour = it.hour
      )
    }
  )
}
