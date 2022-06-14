package com.sopian.challenge7.data.source.remote.response.photodetail

import com.sopian.challenge7.data.source.remote.response.UrlsResponse
import com.sopian.challenge7.data.source.remote.response.UserResponse

data class UnsplashImageDetailResponse(
    val id: String,
    val description: String,
    val urls: UrlsResponse,
    val user: UserResponse,
    val exif: ExifResponse
)
