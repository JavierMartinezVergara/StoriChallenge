package com.javiermtz.storitest.presentation.registration

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ResponseStatus
import com.example.domain.models.ResponseStatus.Success
import com.example.domain.models.UserData
import com.example.domain.usecases.CreateUserUseCase
import com.example.domain.usecases.RegisterUserUseCase
import com.javiermtz.storitest.presentation.registration.RegisterUserState.Loading
import com.javiermtz.storitest.presentation.registration.RegisterUserState.NoCreateUser
import com.javiermtz.storitest.presentation.registration.RegisterUserState.NoRegisterUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterUserViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase,
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {

    private val _userData = MutableStateFlow<UserData>(UserData())
    val userData = _userData.asStateFlow()

    private val _state =
        mutableStateOf<RegisterUserState>(RegisterUserState.Empty)
    val state = _state

    private var isNameValid: MutableState<Boolean> = mutableStateOf(false)
    var nameErrMsg: MutableState<String> = mutableStateOf("")

    private var isLastnameValid: MutableState<Boolean> = mutableStateOf(false)
    var lastNameErrMsg: MutableState<String> = mutableStateOf("")

    private var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    private var isPhoneValid: MutableState<Boolean> = mutableStateOf(false)
    var phoneErrMsg: MutableState<String> = mutableStateOf("")

    private var isAgeValid: MutableState<Boolean> = mutableStateOf(false)
    var ageErrMsg: MutableState<String> = mutableStateOf("")

    private var passwordValue: MutableState<String> = mutableStateOf("")
    private var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledRegisterButton: MutableState<Boolean> = mutableStateOf(false)

    private fun shouldEnabledRegisterButton() {
        isEnabledRegisterButton.value = isEmailValid.value == true &&
            isNameValid.value == true && isLastnameValid.value == true && isAgeValid.value == true &&
            isPhoneValid.value == true && isPasswordValid.value == true
    }

    fun setEmail(email: String) {
        _userData.update {
            _userData.value.copy(
                email = email
            )
        }
    }

    fun setName(name: String) {
        _userData.update {
            _userData.value.copy(
                name = name
            )
        }
    }

    fun setLastname(lastName: String) {
        _userData.update {
            it.copy(
                lastName = lastName
            )
        }
    }

    fun setPhone(phone: String) {
        _userData.update {
            _userData.value.copy(
                mobile = phone
            )
        }
    }

    fun setAge(age: String) {
        _userData.update {
            _userData.value.copy(
                age = age.toIntOrNull() ?: 0
            )
        }
    }

    fun setPassword(password: String) {
        passwordValue.value = password
    }

    fun validateEmail(errorMessage: String) {
        if (!PatternsCompat.EMAIL_ADDRESS.matcher(userData.value.email).matches()) {
            isEmailValid.value = false
            emailErrMsg.value = errorMessage
        } else {
            isEmailValid.value = true
            emailErrMsg.value = ""
        }
        shouldEnabledRegisterButton()
    }

    fun validatePassword(errorMessage: String) {
        if (passwordValue.value.length > 8) {
            isPasswordValid.value = true
            passwordErrMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrMsg.value = errorMessage
        }
        shouldEnabledRegisterButton()
    }

    fun validatePhone(errorMessage: String) {
        if (!Patterns.PHONE.matcher(userData.value.mobile).matches()) {
            isPhoneValid.value = false
            phoneErrMsg.value = errorMessage
        } else {
            isPhoneValid.value = true
            phoneErrMsg.value = ""
        }
        shouldEnabledRegisterButton()
    }

    fun validateName(errorMessage: String) {
        if (userData.value.name.isEmpty()) {
            isNameValid.value = false
            nameErrMsg.value = errorMessage
        } else {
            isNameValid.value = true
            nameErrMsg.value = ""
        }
        shouldEnabledRegisterButton()
    }

    fun validateAge(errorMessage: String) {
        if (userData.value.age in 18..60) {
            isAgeValid.value = true
            ageErrMsg.value = ""
        } else {
            isAgeValid.value = false
            ageErrMsg.value = errorMessage
        }
        shouldEnabledRegisterButton()
    }

    fun validateLastName(errorMessage: String) {
        if (userData.value.lastName.isEmpty()) {
            isLastnameValid.value = false
            lastNameErrMsg.value = errorMessage
        } else {
            isLastnameValid.value = true
            lastNameErrMsg.value = ""
        }
        shouldEnabledRegisterButton()
    }

    fun registerUser() {
        viewModelScope.launch {
            registerUserUseCase(
                _userData.value.email,
                passwordValue.value
            ).collect { responseRegisterUser ->
                _state.value = Loading
                when (responseRegisterUser) {
                    is ResponseStatus.Error -> _state.value = NoRegisterUser(responseRegisterUser.message)
                    is Success -> createUserUseCase(
                        responseRegisterUser.data,
                        userData.value
                    ).collect { responseCreateUser ->
                        when (responseCreateUser) {
                            is ResponseStatus.Error -> _state.value = NoCreateUser(responseCreateUser.message)
                            is Success -> _state.value = RegisterUserState.Success(responseRegisterUser.data)
                        }
                    }
                }
            }
        }
    }
}
