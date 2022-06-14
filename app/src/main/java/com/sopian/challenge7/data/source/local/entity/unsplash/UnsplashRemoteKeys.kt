package com.sopian.challenge7.data.source.local.entity.unsplash

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unsplash_remote_keys")
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)