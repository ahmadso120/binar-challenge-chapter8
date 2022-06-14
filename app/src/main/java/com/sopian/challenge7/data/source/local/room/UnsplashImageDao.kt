package com.sopian.challenge7.data.source.local.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sopian.challenge7.data.source.local.entity.unsplash.UnsplashImageEntity

@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM unsplash_image")
    fun getAllImages(): PagingSource<Int, UnsplashImageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImageEntity>)

    @Query("DELETE FROM unsplash_image")
    suspend fun deleteAllImages()

}