package com.sopian.challenge7.data.source.local

import androidx.lifecycle.LiveData
import com.sopian.challenge7.data.source.local.entity.UserEntity
import com.sopian.challenge7.data.source.local.room.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataSource @Inject constructor(private val userDao: UserDao) {

    fun getUser(email: String): LiveData<UserEntity?> =
        userDao.getUser(email)

    fun login(email: String, password:String): LiveData<UserEntity?> =
        userDao.login(email, password)

    suspend fun insertUser(userEntity: UserEntity) = userDao.insertUser(userEntity)

    suspend fun deleteAllUser() = userDao.deleteAll()

    suspend fun updateUser(userEntity: UserEntity) = userDao.updateUser(userEntity)
}