package com.sopian.challenge7.domain.usecase

import com.sopian.challenge7.data.UnsplashRepository
import com.sopian.challenge7.domain.model.photodetail.UnsplashImageDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(
    private val repository: UnsplashRepository
){
    suspend operator fun invoke(id: String): Flow<UnsplashImageDetail> {
        return repository.getPhotoDetail(id)
    }
}