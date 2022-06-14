package com.sopian.challenge7.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sopian.challenge7.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _isUserHasLoggedIn: MutableState<Boolean> = mutableStateOf(false)
    val isUserHasLoggedIn: State<Boolean> = _isUserHasLoggedIn

    init {
        val isLoggedIn = true
        _isUserHasLoggedIn.value = isLoggedIn
        _isLoading.value = false
    }
}