package com.javiermtz.storitest.presentation.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ResponseStatus
import com.example.domain.models.ResponseStatus.Error
import com.example.domain.models.ResponseStatus.Success
import com.example.domain.usecases.LoginAuthUseCase
import com.javiermtz.storitest.presentation.model.RegisterUser
import com.javiermtz.storitest.presentation.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginAuthUseCase: LoginAuthUseCase
) : ViewModel() {

    private var regUser: RegisterUser = RegisterUser()
    var email: MutableState<String> = mutableStateOf(regUser.email)
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")
    var password: MutableState<String> = mutableStateOf(regUser.password)
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")
    var isEnabledRegisterButton: MutableState<Boolean> = mutableStateOf(false)
    var isChecked: MutableState<Boolean> = mutableStateOf(false)
    private fun shouldEnabledRegisterButton() {
        isEnabledRegisterButton.value = isEmailValid.value == true &&
            isPasswordValid.value == true
    }

    private val loginMutableStateFlow = MutableStateFlow<StatesLogin>(StatesLogin.Empty)
    val loginStateFlow = loginMutableStateFlow.asStateFlow()
    fun validateEmail(errorMessage: String) {
        if (!PatternsCompat.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = false
            emailErrMsg.value = errorMessage
        } else {
            isEmailValid.value = true
            emailErrMsg.value = ""
        }
        shouldEnabledRegisterButton()
    }

    fun validatePassword(errorMessage: String) {
        if (password.value.length > 8) {
            isPasswordValid.value = true
            passwordErrMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrMsg.value = errorMessage
        }
        shouldEnabledRegisterButton()
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginMutableStateFlow.value = StatesLogin.Loading
            loginAuthUseCase(email = email, password = password).collect {
                when (val resource = it) {
                    is Error -> {
                        loginMutableStateFlow.value =
                            StatesLogin.Error(resource.message)
                    }

                    is Success -> {
                        loginMutableStateFlow.value = StatesLogin.Success(
                            UserData(
                                user = resource.data.email,
                                uuid = resource.data.uuid
                            )
                        )
                    }
                }
            }
        }
    }

    fun setState(state: StatesLogin) {
        loginMutableStateFlow.value = state
    }
}
