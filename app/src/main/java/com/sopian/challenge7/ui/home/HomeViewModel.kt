package com.sopian.challenge7.ui.home

import androidx.lifecycle.ViewModel
import com.sopian.challenge7.data.UnsplashRepository
import com.sopian.challenge7.domain.usecase.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getImagesUseCase: GetImagesUseCase
) : ViewModel() {

    val getImages = getImagesUseCase.invoke()
}