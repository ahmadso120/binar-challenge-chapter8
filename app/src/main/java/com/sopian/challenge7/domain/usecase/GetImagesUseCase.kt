package com.sopian.challenge7.domain.usecase

import androidx.paging.PagingData
import com.sopian.challenge7.data.UnsplashRepository
import com.sopian.challenge7.data.source.local.entity.unsplash.UnsplashImageEntity
import com.sopian.challenge7.domain.model.UnsplashImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) {
    operator fun invoke(): Flow<PagingData<UnsplashImage>> {
        return unsplashRepository.getAllImages()
    }
}