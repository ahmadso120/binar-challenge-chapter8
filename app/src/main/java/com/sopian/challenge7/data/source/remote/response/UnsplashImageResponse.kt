package com.sopian.challenge7.data.source.remote.response

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.sopian.challenge7.data.source.local.entity.unsplash.UrlsEntity
import com.sopian.challenge7.data.source.local.entity.unsplash.UserEntity

data class UnsplashImageResponse(
    val id: String,
    val urls: UrlsResponse,
    val likes: Int,
    val user: UserResponse
)
