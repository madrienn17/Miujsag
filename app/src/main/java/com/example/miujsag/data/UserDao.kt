package com.example.miujsag.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.miujsag.models.User
import com.example.miujsag.models.UserPicture

@Dao
interface UserDao {

    //User
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM  user_table ORDER BY id ASC")
    fun selectAllUsers(): LiveData<List<User>>

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    //Pictures
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPic(userPicture: UserPicture)

    @Query("SELECT * from userPic ")
    fun selectUserPics(): LiveData<List<UserPicture>>


}