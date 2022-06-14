package com.sopian.challenge7.domain.usecase

import androidx.paging.PagingData
import com.sopian.challenge7.data.UnsplashRepository
import com.sopian.challenge7.domain.model.UnsplashImage
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchImagesUseCase @Inject constructor(
    private val repository: UnsplashRepository
) {
    operator fun invoke(query: String): Flow<PagingData<UnsplashImage>> {
        return repository.searchImages(query)
    }
}