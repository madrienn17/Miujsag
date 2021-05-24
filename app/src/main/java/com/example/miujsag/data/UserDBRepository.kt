package com.example.miujsag.data

import androidx.lifecycle.LiveData
import com.example.miujsag.models.User
import com.example.miujsag.models.UserPicture

class UserDBRepository (private val userDao: UserDao) {

    val getAllUsers: LiveData<List<User>> = userDao.selectAllUsers()
    val getAllUserPics: LiveData<List<UserPicture>> = userDao.selectUserPics()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }

    suspend fun insertUserPic(userPicture: UserPicture) {
        userDao.insertUserPic(userPicture)
    }

}