package com.example.miujsag.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User(
        val name: String,
        val uni: String,
        val email: String,
        val password: String,
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0
)