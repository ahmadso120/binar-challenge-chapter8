package com.sopian.challenge7.di

import android.content.Context
import androidx.room.Room
import com.sopian.challenge7.data.source.local.room.AppDatabase
import com.sopian.challenge7.data.source.local.room.UnsplashImageDao
import com.sopian.challenge7.data.source.local.room.UnsplashRemoteKeysDao
import com.sopian.challenge7.data.source.local.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "unsplash_db")
            .build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Provides
    fun provideUnsplashImageDao(database: AppDatabase): UnsplashImageDao =
        database.unsplashImageDao()

    @Provides
    fun provideUnsplashRemoteKeysDao(database: AppDatabase): UnsplashRemoteKeysDao =
        database.unsplashRemoteKeysDao()
}