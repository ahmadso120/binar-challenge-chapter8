package com.sopian.challenge7.domain.model.photodetail

import com.sopian.challenge7.domain.model.Urls
import com.sopian.challenge7.domain.model.User

data class UnsplashImageDetail(
    val id: String,
    val description: String?,
    val urls: Urls,
    val user: User,
    val exif: Exif
)
