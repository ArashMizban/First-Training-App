package com.example.room.DB

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class] , version = 2)
abstract class UserDataBase : RoomDatabase(){

    abstract fun userdao() : Dao
}