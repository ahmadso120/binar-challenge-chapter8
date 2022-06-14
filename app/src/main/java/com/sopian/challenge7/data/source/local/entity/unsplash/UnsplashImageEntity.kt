package com.sopian.challenge7.data.source.local.entity.unsplash

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unsplash_image")
data class UnsplashImageEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val urls: UrlsEntity,
    val likes: Int,
    @Embedded
    val user: UserEntity
)
