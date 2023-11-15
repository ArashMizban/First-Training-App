package com.example.room.DB

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.room.Utils.Constans

@Entity(tableName = Constans.USER_TABLE)
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    val userId : Int ,
    val userName : String ,
    val userAge : Int ,
    val Phonenumber : Int
        )