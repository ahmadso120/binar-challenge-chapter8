package com.sopian.challenge7.di

import com.sopian.challenge7.data.UnsplashRepository
import com.sopian.challenge7.data.UnsplashRepositoryImpl
import com.sopian.challenge7.data.UserRepository
import com.sopian.challenge7.data.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideUnsplashRepository(unsplashRepositoryImpl: UnsplashRepositoryImpl): UnsplashRepository

    @Binds
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}