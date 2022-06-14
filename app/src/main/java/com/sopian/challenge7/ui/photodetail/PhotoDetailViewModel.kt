package com.sopian.challenge7.ui.photodetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopian.challenge7.data.UnsplashRepository
import com.sopian.challenge7.domain.model.photodetail.UnsplashImageDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val repository: UnsplashRepository
) : ViewModel(){

    private val _uiState = MutableStateFlow(PhotoDetailUiState(null))
    val uiState: StateFlow<PhotoDetailUiState> = _uiState

    fun getPhotoDetail(id: String) {
        viewModelScope.launch {
            repository.getPhotoDetail(id).collect {
                _uiState.value = PhotoDetailUiState(it)
            }
        }
    }
}

data class PhotoDetailUiState (
    val data: UnsplashImageDetail? = null
)