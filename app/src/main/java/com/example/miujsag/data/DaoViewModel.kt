package com.example.miujsag.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.miujsag.models.User
import com.example.miujsag.models.UserPicture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DaoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserDBRepository
    val readAllUsers: LiveData<List<User>>
    val getAllUserPics: LiveData<List<UserPicture>>


    init {
        val userDao = UserDatabase.getDatabase(application).UserDao()
        repository = UserDBRepository(userDao)
        readAllUsers = repository.getAllUsers
        getAllUserPics = repository.getAllUserPics
    }

    fun addUserDB(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }
    }

    fun deleteAllUserDB() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }

    fun insertUserPic(userPicture: UserPicture) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUserPic(userPicture)
        }
    }

}