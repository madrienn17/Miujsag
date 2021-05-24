package com.example.miujsag.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userPic")
data class UserPicture(
    val userName: String,
    @ColumnInfo(typeAffinity = ColumnInfo.TEXT)
    val userPic: String,
    @PrimaryKey(autoGenerate = true)
    val uPicId: Int = 0
)