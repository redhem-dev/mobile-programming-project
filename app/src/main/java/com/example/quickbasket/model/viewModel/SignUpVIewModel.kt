package com.example.quickbasket.model.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.first
import com.example.quickbasket.model.repositories.UserRepository



class SignUpViewModel(private val userRepository: UserRepository) : ViewModel() {
    var userUiState by mutableStateOf(UsersUiState())
        private set

    fun updateUiState(userDetails: UsersDetails) {
        userUiState = userUiState.copy(usersDetails = userDetails)
    }

    fun validateInput(): Boolean {
        val details = userUiState.usersDetails
        return details.username.isNotBlank() && details.email.isNotBlank() && details.password.isNotBlank()
    }

    fun registerUserTest(){
        userRepository.getOneStream(1)
    }

    suspend fun registerUser(onResult: (Boolean, String?) -> Unit) {
        if (validateInput()) {
            val existingUser = userRepository.getEmail(userUiState.usersDetails.email).first()

            if (existingUser != null) {
                Log.d("SignUpViewModel", existingUser.toString())
                onResult(false, "Email already registered")
            } else {
                Log.d("SignUpViewModel", "8888")
                userRepository.insert(userUiState.usersDetails.toUsers())
                onResult(true, null)
            }
        } else {
            onResult(false, "Invalid input")
        }
    }
}